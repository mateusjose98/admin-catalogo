# Microserviço de Administração de Catálogo de Vídeos

Sistema que gerencia os vídeos, incluindo as categorias, gêneros e elenco.

---
Sobre a organização do domínio com Clean Archtecture + DDD:

- Aggregate Root é uma Entidade.
- Entidade tem um Identificador.
- Aggregate Root tem outras Entidades e Value Objects.
- Value Object não tem identidade e pertence a uma Entidade.
- As entidades sabem se validar. Cada agregate tem uma classe de validação `([Entidade]Validator.java)`  com as devidas regras e acumula um ou vários 'Problem's. Dependendo do tipo de Handler, o Problem pode lançar uma exceção ou ser acumulado para tratamento posterior.
![img.png](img.png)


Regras de validação [Categoria]:

- Nome - preenchimento obrigatório com ao menos 3 caracteres,
- Descrição - preenchimento opcional,
- Ativar/Inativar - se ativa, deleção é null,
- Auditoria (data de criação, atualização e deleção - se inativa, deleção != null)


Regras de valudação [Gênero]:
- Nome - preenchimento obrigatório
- Relação com [Categoria] N-N. Aqui a recomendação é fazer a lidação apenas com o ID, para evitar concorrência entre os agregates;
- Ativar/Inativar
