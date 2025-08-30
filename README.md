## O que aprendi com este projeto

Este projeto foi uma oportunidade prática para consolidar conceitos importantes de modelagem com JPA e persistência com Spring Boot. A seguir, listo os principais aprendizados:

---

### Relacionamento 1:1 com chave primária compartilhada

- Modelei as entidades `Pessoa` e `Cliente` com relacionamento 1:1 utilizando `@OneToOne` e `@MapsId`, garantindo que ambas compartilhem o mesmo ID.
- Compreendi que, nesse padrão, **a entidade dependente (`Cliente`) usa o mesmo ID da entidade principal (`Pessoa`)**, e por isso o ID deve ser gerado no momento em que o `Cliente` é persistido, não antes.

---

### Tratamento de erros comuns no JPA

- **Erro**: `detached entity passed to persist`  
  Aprendi que esse erro ocorre quando tentamos persistir uma entidade (`Cliente`) com uma entidade relacionada (`Pessoa`) que não está mais gerenciada pelo *EntityManager*.  
  Solução: configurar o relacionamento corretamente e persistir o objeto completo em `clienteRepository.save(cliente)`.

---

### CascadeType.MERGE vs. CascadeType.PERSIST

- Testei diferentes tipos de *cascade* e entendi que:
  - `CascadeType.MERGE` é mais seguro quando a entidade associada já pode ter sido salva antes.
  - `CascadeType.PERSIST` tenta persistir a entidade associada automaticamente, mas isso pode causar conflito se ela já existir.
- Optei por `CascadeType.MERGE` por ser mais adequado ao comportamento do projeto.

---

### Ordem de persistência importa

- Descobri que **não posso salvar `Pessoa` antes separadamente** — isso quebra a lógica do relacionamento com chave compartilhada.
- O correto é instanciar a `Pessoa`, atribuí-la ao `Cliente`, e então salvar diretamente com `clienteRepository.save(cliente)`, deixando o JPA cuidar da persistência em cascata.

---

### Depuração com IntelliJ IDEA

- Aprendi a usar o modo debug com mais fluidez:
  - **F9** (Resume Program): pula para o próximo breakpoint ou finaliza a execução se não houver mais.
  - Ícone 🛑 (Stop): encerra a aplicação imediatamente durante o debug.

---

### Limpeza do banco antes de testes

- Para evitar conflitos com chaves duplicadas ou violação de integridade referencial, adicionei `deleteAll()` para limpar as tabelas antes de inserir dados fictícios com o `DataLoader`.
