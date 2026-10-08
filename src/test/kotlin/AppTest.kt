import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Testes de exemplo. Rode com:
 *   ./gradlew test
 *
 * Estes testes rodam tanto na sua máquina quanto no pipeline de CI.
 */
class AppTest {
    @Test
    fun `endpoint health responde ok`() =
        testApplication {
            application { module() }

            val response = client.get("/health")

            assertEquals(HttpStatusCode.OK, response.status)
            assertEquals("""{"status":"ok"}""", response.bodyAsText())
        }

    @Test
    fun `endpoint soma calcula corretamente`() =
        testApplication {
            application { module() }

            val response = client.get("/soma?a=2&b=3")

            assertEquals(HttpStatusCode.OK, response.status)
            assertEquals("""{"resultado":5}""", response.bodyAsText())
        }

    @Test
    fun `soma sem parametros retorna 400`() =
        testApplication {
            application { module() }

            val response = client.get("/soma")

            assertEquals(HttpStatusCode.BadRequest, response.status)
        }

    @Test
    fun `funcao soma soma dois numeros`() {
        assertEquals(5, soma(2, 3))
        assertEquals(0, soma(-1, 1))
        assertEquals(100, soma(40, 60))
    }
}
