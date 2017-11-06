package ru.smarty.resume

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
@Controller
class CvApplication {
    @RequestMapping("/cv")
    fun cv() = "forward:/cv/index.html"

    @RequestMapping("/")
    fun index() = "redirect:/cv"

    @RequestMapping("/cv/data")
    @ResponseBody
    fun cvData() = cv
}

fun main(args: Array<String>) {
    SpringApplication.run(CvApplication::class.java, *args)
}
