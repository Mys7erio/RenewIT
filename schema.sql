psql "postgres://default:ROwIpNm2CsG1@ep-soft-base-a1u5sikv.ap-southeast-1.aws.neon.tech:5432/verceldb?sslmode=require"




CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL UNIQUE,
    password VARCHAR(64) NOT NULL,
    email VARCHAR(64) NOT NULL UNIQUE,
    address varchar,
    phone VARCHAR(10),
    urole VARCHAR CHECK (urole IN ('admin', 'user', 'serviceman')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (name, password, email, address, phone, urole) 
VALUES ('admin', 'password', 'admin@aliviation.me', '8839 69th Road in Forest Hills, Queens, New York', '1234567890', 'admin');



CREATE TABLE items (
    iid SERIAL PRIMARY KEY,
    model VARCHAR(64),
    issue_desc VARCHAR(512)
);


CREATE TABLE submissions (
    sid SERIAL PRIMARY KEY,
    uid INT REFERENCES users(id),
    item_type VARCHAR(64) CHECK (item_type IN ('Laptops', 'Phones', 'Gaming Consoles')),
    model_no VARCHAR(64),
    issue_desc VARCHAR(512),
    repair_cost NUMERIC,
    status VARCHAR(32) DEFAULT 'AWAITING_PICKUP' CHECK (status IN ('AWAITING_PICKUP', 'REPAIR_IN_PROGRESS', 'REPAIR_SUCCESS', 'DELIVERED'))
);


CREATE TABLE appointments (
    aid SERIAL PRIMARY KEY,
    uid INT REFERENCES users(id),
    item_type VARCHAR(64) CHECK (item_type IN ('refrigerator', 'television', 'Air Conditioner')),
    status VARCHAR(32) CHECK (status IN ('APPOINTMENT_CONFIRMED', 'REPAIR_IN_PROGRESS', 'REPAIR_SUCCESS')),
    repair_cost NUMERIC
);



jdbc:postgres://default:ROwIpNm2CsG1@ep-soft-base-a1u5sikv.ap-southeast-1.aws.neon.tech:5432/verceldb?sslmode=require