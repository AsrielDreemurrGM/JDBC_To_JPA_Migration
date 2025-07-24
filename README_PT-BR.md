<h1>Migração JDBC Para JPA</h1>
<p>
  This README is also available in <a href="./README.md">English</a></br>
  <strong>Repositório da Versão JDBC:</strong> <a href="https://github.com/AsrielDreemurrGM/PostgreSQL_JDBC_CRUD">PostgreSQL_JDBC_CRUD</a>
</p>
<p>
  Este projeto é uma migração de uma aplicação CRUD backend Java completa, da abordagem JDBC para JPA (Java Persistence API), mantendo o PostgreSQL como mecanismo de banco de dados.
  Ele preserva a estrutura central do projeto original, introduzindo anotações JPA, mapeamento de relacionamentos entre entidades e integração com a camada de persistência 
  por meio do padrão de projeto DAO.
</p>
<h2>🚀 Tecnologias Utilizadas</h2>
<ul>
  <li>Java 17</li>
  <li>PostgreSQL</li>
  <li>JPA & Hibernate</li>
  <li>JUnit 5</li>
  <li>Padrão de Projeto DAO</li>
  <li>Variáveis de Ambiente para Conexão com o Banco</li>
</ul>
<h2>📂 Estrutura do Projeto</h2>
<ul>
  <li><strong>br.com.eaugusto.domain.jpa</strong> – Classes de entidade JPA com anotações.</li>
  <li><strong>br.com.eaugusto.dao.generics.jpa</strong> – Estrutura DAO genérica usando interfaces e classes de implementação.</li>
  <li><strong>br.com.eaugusto.dao.jpa</strong> – Implementações de DAOs específicos e suas interfaces.</li>
  <li><strong>br.com.eaugusto.domain.jpa</strong> – Classes de teste JUnit 5 cobrindo todas as entidades e lógicas DAO.</li>
</ul>
<h2>✅ Progresso da Migração</h2>
<ul>
  <li>✔️ Projeto base com JDBC importado.</li>
  <li>✔️ Todas as entidades reescritas com anotações JPA.</li>
  <li>✔️ Implementação genérica de DAO criada com segregação de interfaces.</li>
  <li>✔️ Cobertura completa de testes para JPAClient, JPAProduct, JPASelling e JPAProductQuantity.</li>
  <li>✔️ Mapeamento de relacionamentos testado e validado (OneToMany, ManyToOne, etc.).</li>
</ul>
<h2>📄 Variáveis de Ambiente</h2>
<p>Para executar o projeto, configure as seguintes variáveis no seu sistema ou IDE:</p>
<ul>
  <li><code>DB_URL</code> – URL JDBC do seu banco PostgreSQL (ex.: <code>jdbc:postgresql://localhost:5432/online_selling</code>);</li>
  <li><code>DB_USERNAME</code> – Seu nome de usuário do PostgreSQL;</li>
  <li><code>DB_PASSWORD</code> – Sua senha do PostgreSQL.</li>
</ul>
<h2>🧪 Desenvolvimento Orientado a Testes</h2>
<p>O projeto segue os princípios de TDD com testes unitários e de integração abrangentes:</p>
<ul>
  <li>Cálculos de quantidade de produtos validados em <code>JPAProductQuantityTest</code>;</li>
  <li>Lógica de venda e integração com DAO testadas em <code>JPASellingTest</code>;</li>
  <li>Operações CRUD básicas testadas para <code>JPAClient</code> e <code>JPAProduct</code>;</li>
  <li>Isolamento de testes e tratamento de exceções garantidos em todas as camadas DAO.</li>
</ul>
<h2>📘 Configuração de Persistência</h2>
<p>O arquivo <code>persistence.xml</code> está localizado no diretório <code>META-INF</code> e configurado com as seguintes propriedades:</p>
<ul>
  <li>Nome da Unidade de Persistência: <code>JDBC_To_JPA_Migration</code></li>
  <li>Provider: <code>org.hibernate.ejb.HibernatePersistence</code></li>
  <li>Dialeto: <code>org.hibernate.dialect.PostgreSQLDialect</code></li>
  <li>DDL Auto: <code>update</code></li>
  <li>Saída de SQL: <code>hibernate.show_sql = true</code></li>
</ul>
