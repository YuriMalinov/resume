package ru.smarty.resume

import org.junit.Assert.*
import org.junit.Test

class CvDslTest {
    @Test
    fun simpleCVisWorking() {
        val cv = makeCV {
            name = "Test name"

            contacts {
                email = "Test email"
                skype = "Some skype"
            }

            short {
                "Some" {
                    +"Short info"
                    +"List"
                }

                "Several sections" {
                    +"Should also work"
                }
            }

            val skills = object {
                val Java by +group(Lang())
                val Spring by +Tech(Java)

                val Other by +group(Lang())
                val Another by +Tech(Other)
            }

            val roles = object {
                val someRole by +Role()
            }

            object {
                val SomeProject by +Project("Description", skills = listOf(skills.Java), roles = listOf(roles.someRole))
            }
        }

        assertEquals("Test name", cv.name)

        assertEquals(2, cv.shortInfo.size)
        assertEquals("List", cv.shortInfo[0].items[1])
        assertEquals("Some", cv.shortInfo[0].name)

        assertEquals("Java", cv.skills[0][0].name)
        assertEquals("Spring", cv.skills[0][1].name)
        assertEquals("Other", cv.skills[1][0].name)
        assertEquals("Another", cv.skills[1][1].name)

        assertEquals(1, cv.projects.size)
        assertEquals("SomeProject", cv.projects[0].name)
    }
}