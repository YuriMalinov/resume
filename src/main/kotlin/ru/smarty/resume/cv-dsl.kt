package ru.smarty.resume

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


data class CV(
        val name: String,
        val about: String,
        val contacts: Contacts,
        val shortInfo: List<ShortInfo>,
        val education: List<Education>,
        val skills: ArrayList<ArrayList<Skill>>,
        val projects: List<Project>,
        val experiences: List<Experience>
)

class Contacts {
    var email: String? = null
    var skype: String? = null
    var phone: String? = null
    var github: String? = null
    var linkedin: String? = null
}

class Experience(var title: String) {
    var company: String? = null
    var timeRange: Pair<String, String>? = null
    var shortDescription: String? = null
    var tasks = listOf<String>()
    var projects = listOf<Project>()
}

data class Education(val name: String, val year: Int, val speciality: String)

open class HasName(var name: String? = null)

open class Skill(name: String? = null, val notes: String? = null) : HasName(name)

class Lang(val years: Int? = null, notes: String? = null) : Skill(notes = notes)

class Tech(val language: Lang? = null, name: String? = null) : Skill(name)

class Role(name: String? = null) : HasName(name)

data class Project(val description: String? = "", val skills: List<Skill>, val roles: List<Role>) : HasName()

data class ShortInfo(val name: String, val items: List<String>)


class ResumeContext {
    var name: String = ""
    var about: String = ""
    var contacts = Contacts()
    val projects = arrayListOf<Project>()
    val roles = arrayListOf<Role>()
    var education: List<Education> = emptyList()

    val experienceList = arrayListOf<Experience>()
    val short = arrayListOf<ShortInfo>()
    val skills = arrayListOf<ArrayList<Skill>>()
    var currentSkillGroup: ArrayList<Skill> = arrayListOf()


    fun makeResume(): CV {
        return CV(name, about, contacts, short, education, skills, projects, experienceList)
    }

    fun contacts(updater: Contacts.() -> Unit) {
        contacts.updater()
    }

    fun experience(maker: ExperienceContext.() -> Unit) {
        ExperienceContext(experienceList).maker()
    }

    fun short(builder: ShortContext.() -> Unit) {
        ShortContext().builder()
    }

    fun <T : Skill> group(skill: T): T {
        currentSkillGroup = arrayListOf()
        skills.add(currentSkillGroup)
        return skill
    }

    inner class ShortContext {
        operator fun String.invoke(builder: ShortSubContext.() -> Unit) {
            short += ShortInfo(this, ShortSubContext().apply(builder).items)
        }
    }

    class ShortSubContext {
        val items = arrayListOf<String>()

        operator fun String.unaryPlus() {
            items += this
        }
    }


    operator fun Project.unaryPlus() = Collector(this, projects)
    operator fun Role.unaryPlus() = Collector(this, roles)
    operator fun <T : Skill> T.unaryPlus() = Collector<T>(this, currentSkillGroup)

    inner class Collector<out T : HasName>(private val value: T, private val collection: MutableList<in T>) {
        operator fun provideDelegate(thisRef: Any, prop: KProperty<*>): ReadOnlyProperty<Any, T> {
            value.name = value.name ?: prop.name
            collection.add(value)

            return object : ReadOnlyProperty<Any, T> {
                override fun getValue(thisRef: Any, property: KProperty<*>) = value
            }
        }
    }
}

class ExperienceContext(private val experiencesTarget: ArrayList<Experience>) {
    operator fun String.invoke(experienceMaker: Experience.() -> Unit) =
            experiencesTarget.add(Experience(this).apply(experienceMaker))

    operator fun String.minus(other: String) = Pair(this, other)
}

fun makeCV(maker: ResumeContext.() -> Unit): CV {
    return ResumeContext()
            .also { it.maker() }
            .makeResume()
}
