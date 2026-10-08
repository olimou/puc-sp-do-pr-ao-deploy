# Como contribuir

Regras combinadas para a oficina — as mesmas que equipes de engenharia
usam no dia a dia.

## Commits

Use mensagens no padrão **Conventional Commits**:

```
<tipo>: <descrição curta no imperativo>
```

Tipos comuns: `feat`, `fix`, `docs`, `test`, `refactor`, `chore`.

Exemplos:
- `feat: adiciona endpoint /soma`
- `fix: corrige validação de parâmetros`
- `test: cobre o caso de soma com negativos`
- `docs: explica como rodar os testes`

## Padrão de código (lint)

O projeto usa **[ktlint](https://pinterest.github.io/ktlint/)** para garantir um
estilo consistente. O pipeline de CI roda a verificação — código fora do padrão
**não passa**.

- Verificar o padrão: `./gradlew ktlintCheck`
- Corrigir automaticamente o que for possível: `./gradlew ktlintFormat`

Rode `ktlintFormat` antes de commitar e a etapa de **Lint** do CI passará.

## Pull Requests

Um bom PR tem:

- **Título** claro e curto (mesmo padrão do commit).
- **Descrição** com:
  - **O quê** mudou
  - **Por quê**
  - **Como testar** (passos para o revisor reproduzir)
- **Escopo pequeno** — PRs grandes são difíceis de revisar.

## Code review

- Leia o diff com calma; comente linhas específicas.
- Use **suggestion** para propor a mudança exata.
- Aprove (*Approve*) ou peça ajustes (*Request changes*) com educação.
- Review é uma conversa técnica, não um julgamento de quem escreveu.

## Regra de ouro

> **Nada de merge sem CI verde.** A branch `main` é protegida: só entra
> código com Pull Request aprovado e pipeline passando.
