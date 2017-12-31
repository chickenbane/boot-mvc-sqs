package slalom.sqs

import com.amazonaws.services.sqs.AmazonSQSAsync
import org.slf4j.LoggerFactory
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class SqsQueueSender(amazonSqs: AmazonSQSAsync) {
    private val log = LoggerFactory.getLogger(SqsQueueSender::class.java)

    private val queueMessager = QueueMessagingTemplate(amazonSqs)

    fun send(msg: String) {
        log.info("sending message=$msg")
        queueMessager.send(queueName, MessageBuilder.withPayload(msg).build())
    }

    @SqsListener(queueName)
    fun listener(msg: String) {
        log.info("listener: msg=$msg")
    }

    companion object {
        const val queueName = "babys-first-queue"
    }
}