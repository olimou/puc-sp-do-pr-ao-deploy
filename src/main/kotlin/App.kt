import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * Aplicação de exemplo do workshop.
 *
 * Expõe dois endpoints simples e uma função pura (`soma`) que é o alvo
 * dos testes automatizados:
 *   GET /health              -> {"status":"ok"}
 *   GET /soma?a=2&b=3        -> {"resultado":5}
 */
fun main() {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 8080
    embeddedServer(Netty, port = port, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    routing {
        get("/health") {
            call.respondText("""{"status":"ok"}""", ContentType.Application.Json, HttpStatusCode.OK)
        }
        get("/soma") {
            val a = call.parameters["a"]?.toIntOrNull()
            val b = call.parameters["b"]?.toIntOrNull()
            if (a == null || b == null) {
                call.respondText(
                    """{"erro":"informe os parametros a e b"}""",
                    ContentType.Application.Json,
                    HttpStatusCode.BadRequest,
                )
            } else {
                call.respondText(
                    """{"resultado":${soma(a, b)}}""",
                    ContentType.Application.Json,
                    HttpStatusCode.OK,
                )
            }
        }
    }
}

/** Função pura — fácil de testar sem subir o servidor. */
fun soma(
    a: Int,
    b: Int,
): Int = a + b
