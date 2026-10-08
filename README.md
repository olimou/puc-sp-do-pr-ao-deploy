# puc-sp-do-pr-ao-deploy

Repositório de apoio do workshop **"Do Pull Request ao Deploy"**.

Aplicação mínima em **Kotlin + Ktor**, usada para praticar o fluxo
profissional de desenvolvimento: branch → commit → PR → review → testes
→ CI → merge → deploy.

## Endpoints

| Método | Rota | Resposta |
| --- | --- | --- |
| GET | `/health` | `{"status":"ok"}` |
| GET | `/soma?a=2&b=3` | `{"resultado":5}` |

## Pré-requisitos

- JDK 21 (Temurin) — ou rode `mise install` (o repo traz um `.mise.toml` com `java = "21"`)
- Git configurado (`user.name` e `user.email`)
- Uma IDE (IntelliJ IDEA Community serve)

## Como rodar

```bash
git clone git@github.com:<seu-usuario>/puc-sp-do-pr-ao-deploy.git
cd puc-sp-do-pr-ao-deploy
./gradlew test          # roda os testes
./gradlew ktlintCheck   # verifica o padrão de código
./gradlew run           # sobe o servidor em http://localhost:8080
```

Abrir no navegador: http://localhost:8080/health

## Fluxo da oficina

1. **Fork** deste repositório para a sua conta.
2. Clone o **seu fork** e crie uma branch: `git checkout -b feat/minha-mudanca`.
3. Faça uma mudança pequena, `commit` e `push`.
4. Abra um **Pull Request** apontando para a `main` deste repo.
5. Peça **review** ao colega (e revise o PR dele).
6. Veja o **CI** rodar e ficar verde.
7. Após o merge, o workflow de **Deploy** roda e "publica" a aplicação (simulado).

Veja `CONTRIBUTING.md` para o padrão de commits e de Pull Request.
