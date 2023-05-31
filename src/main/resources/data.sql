CREATE TABLE students
(
    id    BIGINT PRIMARY KEY,
    studentId BIGINT PRIMARY KEY,
    name  VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE FeePayments
(
    id           BIGINT PRIMARY KEY,
    student_id   BIGINT,
    amount       DECIMAL(10, 2),
    payment_date TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students (id)
);


INSERT INTO students (id, name, email)
VALUES (1, 'John Doe', 'john.doe@example.com'),
       (2, 'Jane Smith', 'jane.smith@example.com');

INSERT INTO FeePayments (id, student_id, amount, payment_date)
VALUES (1, 1, 1000.00, '2022-01-05 10:00:00'),
       (2, 2, 1500.00, '2022-02-10 15:30:00'),
       (3, 1, 2000.00, '2022-03-15 12:45:00');