package re.neotamia.ntdiscordbot.core

import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent

suspend fun main() {
    val token = System.getenv("DISCORD_TOKEN") ?: error("DISCORD_TOKEN is not set")
    val kord = Kord(token)

    kord.login {
        @OptIn(PrivilegedIntent::class)
        intents += Intent.MessageContent

        presence {
            playing("NeoTamia BOT - Support")
        }
    }
}
