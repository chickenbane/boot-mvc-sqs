package slalom.sqs

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("sqs")
class SqsController(private val queueSender: SqsQueueSender) {
    private val log = LoggerFactory.getLogger(SqsController::class.java)

    @GetMapping("boot", produces = ["application/json"])
    fun getBoot() = Boot(42, "best message")

    @PostMapping("putMessage")
    fun putMessage(@RequestBody body: String) {
        log.info("hi got message=$body")
        queueSender.send(body)
    }
}

data class Boot(val number: Int, val message: String)