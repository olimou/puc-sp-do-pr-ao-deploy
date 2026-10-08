<!--
TÍTULO do PR: use o padrão do commit — ex.: "feat: adiciona endpoint /subtracao"
(tipos: feat, fix, docs, test, refactor, chore)
-->

## O quê
<!-- Resuma a mudança em 1–2 linhas. O que este PR entrega? -->

## Por quê
<!-- Motivo / contexto. Linke a issue, ex.: Refs #12 -->

## Como testar
<!-- Passos para o revisor reproduzir -->
1. `./gradlew test`
2. `./gradlew run`
3. `curl "http://localhost:8080/..."` → resposta esperada

## Checklist
- [ ] Título no padrão do commit
- [ ] Testes passando localmente (`./gradlew test`)
- [ ] Padrão de código ok (`./gradlew ktlintCheck`)
- [ ] Escopo pequeno e focado
