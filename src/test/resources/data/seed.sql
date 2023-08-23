-- categories seed
INSERT INTO categories (id, name, created_at, updated_at) VALUES (gen_random_uuid(), 'CASA', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES (gen_random_uuid(), 'COMPRAS', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES (gen_random_uuid(), 'SAÚDE', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES (gen_random_uuid(), 'AUTOMÓVEL', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES (gen_random_uuid(), 'BEM ESTAR', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES (gen_random_uuid(), 'INVESTIMENTO', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES (gen_random_uuid(), 'SALÁRIO', NOW(), NOW());
INSERT INTO categories (id, name, created_at, updated_at) VALUES (gen_random_uuid(), 'OUTROS', NOW(), NOW());

-- transactions seed
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES (gen_random_uuid(), 'Conta de luz', 'EXPENSE', 100.0, NOW(), SELECT id FROM categories WHERE name = 'CASA', NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES (gen_random_uuid(), 'Compras mercado', 'INCOME', 2500.0, NOW(), (SELECT id FROM categories WHERE name = 'COMPRAS'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES (gen_random_uuid(), 'Checkup médico', 'EXPENSE', 150.0, NOW(), (SELECT id FROM categories WHERE name = 'SAÚDE'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES (gen_random_uuid(), 'Manutenção carro', 'EXPENSE', 200.0, NOW(), (SELECT id FROM categories WHERE name = 'AUTOMÓVEL'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES (gen_random_uuid(), 'Tratamento de beleza', 'EXPENSE', 80.0, NOW(), (SELECT id FROM categories WHERE name = 'BEM ESTAR'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES (gen_random_uuid(), 'Investimento na bolsa', 'EXPENSE', 500.0, NOW(), (SELECT id FROM categories WHERE name = 'INVESTIMENTO'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES (gen_random_uuid(), 'Salário', 'INCOME', 3000.0, NOW(), (SELECT id FROM categories WHERE name = 'SALÁRIO'), NOW(), NOW());
INSERT INTO transactions (id, name, type, price, entry_date, category_id, created_at, updated_at) VALUES (gen_random_uuid(), 'Compras aliexpress', 'EXPENSE', 50.0, NOW(), (SELECT id FROM categories WHERE name = 'OUTROS'), NOW(), NOW());
