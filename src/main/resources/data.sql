INSERT INTO customer (username, cin) VALUES
('John Doe', 'AB123456'),
('Jane Smith', 'CD789012'),
('Alice Johnson', 'EF345678');

INSERT INTO account (balance, creation_time, customer_id) VALUES
(1000.0, CURRENT_TIMESTAMP, 1),
(2500.0, CURRENT_TIMESTAMP, 2),
(500.0, CURRENT_TIMESTAMP, 3);
