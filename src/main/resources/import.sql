-- Inserir dados na tabela State
INSERT INTO tb_state (name, country) VALUES ('São Paulo', 'São Paulo');

-- Inserir dados na tabela City
INSERT INTO tb_city (name, city_area, state_id) VALUES ('Barueri - SP', 'Zona Oeste', 1);

-- Inserir dados na tabela Contact Data
INSERT INTO tb_contact_data(phone, street_or_avenue, email) VALUES ('11-945589975', 'Avenida Aruanã 851 - Apartamento 182 B', 'vinicius.pascucci1@gmail.com')

-- Inserir dados na tabela Bank Account Detailing
INSERT INTO tb_banking_account(full_name_account_holder, number_bank, number_bank_account, cpf_cnpj_account_holder, contact_data_id, balance_account, password_or_acces_code) VALUES ('Vinicius Torres Pascucci', 341, 192711, 42155435843, 1, 4500.0, '123456789')

-- Inserir dados na tabela Bank Detailing Account
INSERT INTO tb_bank_card(name, flag_credit_card, type_credit_card, limit_credit_card, banking_account_id) VALUES('ItauCard MAESTRO Final 7590', 'MASTERCARD', 'Multiplo Debito/Credito', 20900.0, 1)

-- Inserir dados na tabela Banking Extract
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, banking_account_id, pendency_amount) VALUES ('2023-07-26', 1250.0, 'Miscellaneous Expenses', 'rshop-convenienci-26/07', 1, 16.55)


