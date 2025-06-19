## Projeto E-Commerce
#### Autores
- [Fábio Simones](https://github.com/FabioSimones)

### Descrição do projeto:
<p>Neste repositório você encontrará um sistema e-commerce para gerenciamento de usuários,
 produtos, tags, pedidos e itens de pedido.</p>

### Estrutura do projeto
<ul>
  <li>Entidades</li>
  <ul>
    <li>Relacionamentos entre tabelas:</li>
    <ul>
      <li>Usuário para Endereço de Cobrança (one-to-one)</li>
      <li>Pedido para Usuário (many-to-one</li>
      <li>Pedido para Item do Pedido (one-to-many)</li>
      <li>Item do Pedido para Pedido (many-to-one)</li>
      <li>Item do Pedido para Produto (many-to-one)</li>
      <li>Produto para Tags (many-to-many)</li>
    </ul>    
  </ul>  
</ul>
</br>

<ul>
  <li>Regras do projeto</li>
  <ul>
    <li>Precisamos das seguintes informações nas tabelas:</li>
    <ul>
      <li>Usuário:</li>
      <ul>
        <li>Código do usuário</li>
        <li>Nome Completo</li>
      </ul>
    </ul> 
    <ul>
      <li>Endereço da cobrança:</li>
      <ul>
        <li>Rua</li>
        <li>Número</li>
        <li>Complemento</li>
        <li>Usuário que pertence este endereço</li>
      </ul>
    </ul>
    <ul>
      <li>Pedido:</li>
      <ul>
        <li>Número do pedido</li>
        <li>Valor total</li>
        <li>Data do pedido</li>
        <li>Usuário que fez o pedido</li>
      </ul>
    </ul> 
    <ul>
      <li>Item do pedido:</li>
      <ul>
        <li>A qual pedido pertence este item</li>
        <li>A qual produto pertence este item</li>
        <li>Valor pago pelo usuário no item</li>
        <li>Quantidade de itens</li>
      </ul>
    </ul> 
    <ul>
      <li>Produto:</li>
      <ul>
        <li>Código do produto</li>
        <li>Nome</li>
        <li>Preço</li>
        <li>Tags vinculados ao produto</li>
      </ul>
    </ul> 
    <ul>
      <li>Tag:</li>
      <ul>
        <li>Código da tag</li>
        <li>Nome</li>
      </ul>
    </ul> 
  </ul>  
</ul>

<p>Ao completar o projeto Sistema de E-commerce, foi possivel adquirir uma experiência prática na configuração de um projeto Spring Boot, 
 configuração de um banco de dados, definição de entidades JPA, criação de repositórios, implementação de uma camada de serviço e 
 exposição de APIs RESTful para operações CRUD e relacionamentos entre entidades.</p>

 <p>Este projeto ajudou a me capacitar com o conhecimento e as habilidades necessárias para construir e gerenciar sistemas backend 
  robustos usando Spring Boot e Spring Data JPA.</p>

  ## Diagrama UML
  ![image](https://github.com/user-attachments/assets/86b222cc-5b91-48b7-b13c-ad015e7c7e9a)

