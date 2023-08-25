-- categories seed
INSERT INTO categories (id, name, created_at, updated_at) VALUES ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'CASA', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES ('6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'COMPRAS', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES ('6ba7b812-9dad-11d1-80b4-00c04fd430c8', 'SAÚDE', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES ('6ba7b813-9dad-11d1-80b4-00c04fd430c8', 'AUTOMÓVEL', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES ('6ba7b814-9dad-11d1-80b4-00c04fd430c8', 'BEM ESTAR', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES ('6ba7b815-9dad-11d1-80b4-00c04fd430c8', 'INVESTIMENTO', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES ('6ba7b816-9dad-11d1-80b4-00c04fd430c8', 'SALÁRIO', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES ('6ba7b817-9dad-11d1-80b4-00c04fd430c8', 'OUTROS', NOW(), NOW());

-- transactions seed
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES ('6ba7b818-9dad-11d1-80b4-00c04fd430c8', 'Conta de luz', 'EXPENSE', 100.0, NOW(), (SELECT id FROM categories WHERE name = 'CASA'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES ('6ba7b819-9dad-11d1-80b4-00c04fd430c8', 'Compras mercado', 'INCOME', 2500.0, NOW(), (SELECT id FROM categories WHERE name = 'COMPRAS'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES ('6ba7b81a-9dad-11d1-80b4-00c04fd430c8', 'Checkup médico', 'EXPENSE', 150.0, NOW(), (SELECT id FROM categories WHERE name = 'SAÚDE'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES ('6ba7b81b-9dad-11d1-80b4-00c04fd430c8', 'Manutenção carro', 'EXPENSE', 200.0, NOW(), (SELECT id FROM categories WHERE name = 'AUTOMÓVEL'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES ('6ba7b81c-9dad-11d1-80b4-00c04fd430c8', 'Tratamento de beleza', 'EXPENSE', 80.0, NOW(), (SELECT id FROM categories WHERE name = 'BEM ESTAR'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES ('6ba7b81d-9dad-11d1-80b4-00c04fd430c8', 'Investimento na bolsa', 'EXPENSE', 500.0, NOW(), (SELECT id FROM categories WHERE name = 'INVESTIMENTO'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES ('6ba7b81e-9dad-11d1-80b4-00c04fd430c8', 'Salário', 'INCOME', 3000.0, NOW(), (SELECT id FROM categories WHERE name = 'SALÁRIO'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES ('6ba7b81f-9dad-11d1-80b4-00c04fd430c8', 'Compras aliexpress', 'EXPENSE', 50.0, NOW(), (SELECT id FROM categories WHERE name = 'OUTROS'), NOW(), NOW());
