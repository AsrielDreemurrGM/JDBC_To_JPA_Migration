<h1>JDBC To JPA Migration</h1>
<p>
  Esse README também está disponível em 
  <a href="./README_PT-BR.md">Português Brasileiro</a><br>
  <strong>Repository Link to JDBC Version:</strong> 
  <a href="https://github.com/AsrielDreemurrGM/PostgreSQL_JDBC_CRUD">PostgreSQL_JDBC_CRUD</a>
</p>
<p>
  This project is a migration of a full Java backend CRUD application from JDBC to JPA (Java Persistence API), maintaining PostgreSQL as the database engine. 
  It preserves the core structure of the original project while introducing JPA annotations, entity relationships, and integration with the persistence layer 
  via the DAO design pattern.
</p>
<h2>🚀 Technologies Used</h2>
<ul>
  <li>Java 17</li>
  <li>PostgreSQL</li>
  <li>JPA & Hibernate</li>
  <li>JUnit 5</li>
  <li>DAO Design Pattern</li>
  <li>Environment Variables for DB Connection</li>
</ul>
<h2>📂 Project Structure</h2>
<ul>
  <li><strong>br.com.eaugusto.domain.jpa</strong> – JPA entity classes with annotations.</li>
  <li><strong>br.com.eaugusto.dao.generics.jpa</strong> – Generic DAO structure using interfaces and implementation classes.</li>
  <li><strong>br.com.eaugusto.dao.jpa</strong> – Specific DAO implementations and interfaces.</li>
  <li><strong>br.com.eaugusto.domain.jpa</strong> – JUnit 5 test classes covering all entities and DAO logic.</li>
</ul>
<h2>✅ Migration Progress</h2>
<ul>
  <li>✔️ JDBC base project imported;</li>
  <li>✔️ All entities rewritten using JPA annotations;</li>
  <li>✔️ Generic DAO implementation created with interface segregation;</li>
  <li>✔️ Full test coverage for JPAClient, JPAProduct, JPASelling, and JPAProductQuantity;</li>
  <li>✔️ Relationship mapping tested and verified (OneToMany, ManyToOne, etc.).</li>
</ul>
<h2>📄 Environment Variables</h2>
<p>To run the project, configure the following variables in your system or IDE:</p>
<ul>
  <li><code>DB_URL</code> – JDBC URL for your PostgreSQL database (e.g., <code>jdbc:postgresql://localhost:5432/online_selling</code>);</li>
  <li><code>DB_USERNAME</code> – Your PostgreSQL username;</li>
  <li><code>DB_PASSWORD</code> – Your PostgreSQL password.</li>
</ul>
<h2>🧪 Test-Driven Development</h2>
<p>The project follows TDD principles with extensive unit and integration testing:</p>
<ul>
  <li>Product quantity calculations validated in <code>JPAProductQuantityTest</code>;</li>
  <li>Sale logic and DAO integration tested in <code>JPASellingTest</code>;</li>
  <li>All basic CRUD operations tested for <code>JPAClient</code> and <code>JPAProduct</code>;</li>
  <li>Test isolation and exception handling ensured across all DAO layers.</li>
</ul>
<h2>📘 Persistence Configuration</h2>
<p>The <code>persistence.xml</code> file is located in the <code>META-INF</code> directory and configured with the following properties:</p>
<ul>
  <li>Persistence Unit Name: <code>JDBC_To_JPA_Migration</code></li>
  <li>Provider: <code>org.hibernate.ejb.HibernatePersistence</code></li>
  <li>Dialect: <code>org.hibernate.dialect.PostgreSQLDialect</code></li>
  <li>DDL Auto: <code>update</code></li>
  <li>SQL Output: <code>hibernate.show_sql = true</code></li>
</ul>
<h2>📝 Javadoc Documentation</h2>
<p>The entire codebase has been documented with Javadoc to improve maintainability and comprehension:</p>
<ul>
  <li>✅ All domain entities include class-level and method-level documentation;</li>
  <li>✅ DAO interfaces and implementations are fully documented, including exceptions and custom operations;</li>
  <li>✅ Generic DAO structure explained and linked using <code>{@link}</code> annotations for better IDE navigation;</li>
  <li>✅ All test classes now include documentation describing test purpose, coverage, and exception handling strategies.</li>
</ul>
