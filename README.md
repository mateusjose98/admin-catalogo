# Microserviço de Administração de Catálogo de Vídeos

Sistema que gerencia os vídeos, incluindo as categorias, gêneros e elenco.

---
Sobre a organização do domínio com DDD:

- Aggregate Root é uma Entidade.
- Entidade tem um Identificador.
- Aggregate Root tem outras Entidades e Value Objects.
- Value Object não tem identidade e pertence a uma Entidade.

![img.png](img.png)


Regras de validação [Categoria]:

- Nome - preenchimento obrigatório com ao menos 3 caracteres,
- Descrição - preenchimento opcional,
- Ativar/Inativar - se ativa, deleção é null,
- Auditoria (data de criação, atualização e deleção - se inativa, deleção != null)
