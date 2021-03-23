# bankingSystem

### Admin role with features:

Sign in/out as admin.

Add bank employees.

Delete employees.

### Employee role with feature:

Sign in/out as an employee. 

Create a customer.

Create accounts like savings, salary, loan, current account etc.

Link customers with accounts.

Update KYC for a customer.

Get details of a customer.

Delete customer.

Get account balance for an account.

Transfer money from one account to another.

Print Account statement of an account for a time range in pdf.

Calculate interest for the money annually (at 3.5% p.a.) and update the account balance.


postman curl collection: https://www.getpostman.com/collections/610b142d29357acc5c09

## Entities
    +----------------+
    | Tables_in_test |
    +----------------+
    | account        |
    | customer       |
    | ledger         |
    | user           |
    +----------------+
    
    mysql> desc user;
    +----------+--------------+------+-----+---------+----------------+
    | Field    | Type         | Null | Key | Default | Extra          |
    +----------+--------------+------+-----+---------+----------------+
    | id       | int          | NO   | PRI | NULL    | auto_increment |
    | password | varchar(255) | YES  |     | NULL    |                |
    | type     | varchar(255) | YES  |     | NULL    |                |
    | username | varchar(255) | YES  | UNI | NULL    |                |
    +----------+--------------+------+-----+---------+----------------+
    
    mysql> desc customer;
    +---------------+--------------+------+-----+---------+----------------+
    | Field         | Type         | Null | Key | Default | Extra          |
    +---------------+--------------+------+-----+---------+----------------+
    | id            | int          | NO   | PRI | NULL    | auto_increment |
    | customer_name | varchar(255) | YES  |     | NULL    |                |
    | iskycdone     | bit(1)       | YES  |     | NULL    |                |
    +---------------+--------------+------+-----+---------+----------------+
    
    mysql> desc account;
    +--------------+--------+------+-----+---------+----------------+
    | Field        | Type   | Null | Key | Default | Extra          |
    +--------------+--------+------+-----+---------+----------------+
    | id           | int    | NO   | PRI | NULL    | auto_increment |
    | account_type | int    | YES  |     | NULL    |                |
    | balance      | double | YES  |     | NULL    |                |
    | customer_id  | int    | YES  |     | NULL    |                |
    +--------------+--------+------+-----+---------+----------------+
    
    mysql> desc ledger;
    +----------------------------+--------+------+-----+---------+----------------+
    | Field                      | Type   | Null | Key | Default | Extra          |
    +----------------------------+--------+------+-----+---------+----------------+
    | id                         | int    | NO   | PRI | NULL    | auto_increment |
    | amount                     | double | YES  |     | NULL    |                |
    | dest_account_id            | int    | YES  |     | NULL    |                |
    | src_account_id             | int    | YES  |     | NULL    |                |
    | transaction_time_in_millis | int    | YES  |     | NULL    |                |
    +----------------------------+--------+------+-----+---------+----------------+
    
    