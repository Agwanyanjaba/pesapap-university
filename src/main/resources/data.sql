CREATE TABLE students
(
    student_id BIGINT PRIMARY KEY,
    first_name  VARCHAR(100),
    last_name  VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE payments
(
    payment_id   VARCHAR(250) PRIMARY KEY,
    student_id   BIGINT,
    amount       DECIMAL(10, 2),
    payment_channel VARCHAR(100),
    payment_description VARCHAR(250),
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students (student_id)
);


INSERT INTO students (student_id, first_name, last_name, email)
VALUES (1, 'John', 'Doe', 'john.doe@example.com'),
       (2, 'Jane', 'Smith', 'jane.smith@example.com');

INSERT INTO payments (payment_id, student_id, amount, payment_channel, payment_description, payment_date)
VALUES ('9a1a9e2c-ffc3-11ed-be56-0242ac120001', 1, 1000.00,'mobile','Fee Payment',CURRENT_TIMESTAMP),
       ('9a1a9e2c-ffc3-11ed-be56-0242ac120002', 2, 1500.00, 'mobile','Fee Payment',CURRENT_TIMESTAMP),
       ('9a1a9e2c-ffc3-11ed-be56-0242ac120003', 1, 2000.00, 'mobile','Fee Payment', CURRENT_TIMESTAMP),
       ('9a1a9e2c-ffc3-11ed-be56-0242ac120004', 2, 2000.00, 'mobile','Fee Payment', CURRENT_TIMESTAMP);
