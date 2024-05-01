RO: Vom parcurge următoarele etape:

1. Crearea unui proiect Maven care utilizează JDBC

2. Preluarea datelor din baza de date (MySQL Workbench):

- stabilirea unei conexiuni către baza de date;

- execuţia interogărilor SQL;

- procesarea rezultatelor;

- închiderea unei conexiuni la baza de date.

7. Rularea comenzilor SQL cu parametri:

- se extrag date din tabelul persoane, filtrând doar persoanele care au un nume precizat şi o vârstă mai mică decât o valoare precizată, iar exemplul rulează o interogare select cu parametri

8. Actualizarea bazei de date cu ajutorul comenzilor SQL:

- pentru a adăuga, modifica şi şterge date în/din tabela "persoane",  exemplul rulează comenzi SQL cu parametri cu ajutorul obiectului PreparedStatement;

- interfeţele Statement, PreparedStatement, Connection, ResultSet implementează interfaţa AutoCloseable, putând fi folosite în blocuri try cu resurse, pentru ca resursa să fie închisă automat;

- în blocurile catch se afişează pe lângă mesajul excepţiei şi comanda SQL care a determinat-o;

- metoda executeUpdate() este utilizată pentru a rula comenzile SQL insert, update şi delete;

- valorile efective ale parametrilor au fost stabilite prin metodele setInt(nr_parametru,valoare) sau setString(nr_parametru,valoare); 

- accesarea coloanelor din ResultSet s-a făcut de această dată precizând index-ul coloanei, nu denumirea acesteia.

EN: We will go through the following steps:

1. Creating a Maven project that uses JDBC.

2. Retrieving data from the database (MySQL Workbench):

- Establishing a connection to the database;
     
- Executing SQL queries;
     
- Processing the results;
     
- Closing a database connection.

7. Running SQL commands with parameters:

- Data is extracted from the "persons" table, filtering only those individuals who have a specified name and an age less than a specified value; the example runs a select query with parameters.

8. Updating the database using SQL commands:

- To add, modify, and delete data in/from the "persons" table, the example runs SQL commands with parameters using the PreparedStatement object;
     
- The interfaces Statement, PreparedStatement, Connection, ResultSet implement the AutoCloseable interface, allowing them to be used in try-with-resources blocks so that the resource is automatically closed;
     
- In the catch blocks, in addition to the exception message, the SQL command that caused it is displayed;
     
- The executeUpdate() method is used to run SQL commands such as insert, update, and delete;
     
- The actual values of the parameters were set using the methods setInt(parameter_number, value) or setString(parameter_number, value);
     
- Accessing columns from the ResultSet this time was done by specifying the column index, not its name.
