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

