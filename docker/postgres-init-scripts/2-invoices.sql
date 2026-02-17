CREATE SCHEMA invoices;

CREATE TABLE invoices.invoices
(
    id          VARCHAR(50) PRIMARY KEY,
    client_id   VARCHAR(50)  NOT NULL,
    client_name VARCHAR(255) NOT NULL,
    created_at  DATE         NOT NULL,
    issued_at   DATE         NOT NULL
);

CREATE TABLE invoices.invoice_lines
(
    invoice_id    VARCHAR(50)    NOT NULL,
    product_id    VARCHAR(50)    NOT NULL,
    product_price NUMERIC(10, 2) NOT NULL,
    units         INTEGER        NOT NULL,

    PRIMARY KEY (invoice_id, product_id),

    CONSTRAINT fk_invoice
        FOREIGN KEY (invoice_id)
            REFERENCES invoices.invoices (id)
            ON DELETE CASCADE
);

INSERT INTO invoices.invoices (id, client_id, client_name, created_at, issued_at)
VALUES ('inv-1', 'client-1', 'Carlos García López', '2025-02-01', '2025-02-01');

INSERT INTO invoices.invoices (id, client_id, client_name, created_at, issued_at)
VALUES ('inv-2', 'client-2', 'María Martínez Sánchez', '2025-02-10', '2025-02-10');

INSERT INTO invoices.invoices (id, client_id, client_name, created_at, issued_at)
VALUES ('inv-3', 'client-1', 'Carlos García López', '2025-02-15', '2025-02-15');



INSERT INTO invoices.invoice_lines (invoice_id, product_id, product_price, units)
VALUES ('inv-1', 'prod-1', 899.99, 1);

INSERT INTO invoices.invoice_lines (invoice_id, product_id, product_price, units)
VALUES ('inv-1', 'prod-2', 249.50, 2);

INSERT INTO invoices.invoice_lines (invoice_id, product_id, product_price, units)
VALUES ('inv-2', 'prod-3', 89.99, 3);

INSERT INTO invoices.invoice_lines (invoice_id, product_id, product_price, units)
VALUES ('inv-2', 'prod-4', 45.00, 2);

INSERT INTO invoices.invoice_lines (invoice_id, product_id, product_price, units)
VALUES ('inv-3', 'prod-5', 79.99, 5);