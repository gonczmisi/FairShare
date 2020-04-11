-- Insert data for TESTING
-- Users
INSERT INTO public.User(id, created_at, updated_at, username, password, email_address, user_role) VALUES(0, NOW(), NOW(), 'user_by_id', 'password', 'by@id.id', 'TEST');
INSERT INTO public.User(id, created_at, updated_at, username, password, email_address, user_role) VALUES(1, NOW(), NOW(), 'user_by_name', 'password', 'by@name.name', 'TEST');
INSERT INTO public.User(id, created_at, updated_at, username, password, email_address, user_role) VALUES(2, NOW(), NOW(), 'user_by_email_address', 'password', 'by@email.address', 'TEST');
INSERT INTO public.User(id, created_at, updated_at, username, password, email_address, user_role) VALUES(3, NOW(), NOW(), 'user_by_role', 'password', 'by@role.role', 'TEST');
-- Items
INSERT INTO public.Item(id, created_at, updated_at, name, price, currency_type) VALUES(0, NOW(), NOW(), 'test_item_01', 666, 'USD');
INSERT INTO public.Item(id, created_at, updated_at, name, price, currency_type) VALUES(1, NOW(), NOW(), 'test_item_02', 777, 'HUF');
INSERT INTO public.Item(id, created_at, updated_at, name, price, currency_type) VALUES(2, NOW(), NOW(), 'test_item_03', 888, 'HUF');
INSERT INTO public.Item(id, created_at, updated_at, name, price, currency_type) VALUES(3, NOW(), NOW(), 'test_item_04', 999, 'HUF');
-- Receipts
INSERT INTO public.Receipt(id, created_at, updated_at, name) VALUES(0, NOW(), NOW(), 'test_receipt_01');
INSERT INTO public.Receipt(id, created_at, updated_at, name) VALUES(1, NOW(), NOW(), 'test_receipt_02');
INSERT INTO public.Receipt(id, created_at, updated_at, name) VALUES(2, NOW(), NOW(), 'test_receipt_03');
INSERT INTO public.Receipt(id, created_at, updated_at, name) VALUES(3, NOW(), NOW(), 'test_receipt_04');
-- Items_Receipts
INSERT INTO public.Items_Receipts(item_id, receipt_id) VALUES(0, 0);
INSERT INTO public.Items_Receipts(item_id, receipt_id) VALUES(0, 1);
INSERT INTO public.Items_Receipts(item_id, receipt_id) VALUES(0, 2);
INSERT INTO public.Items_Receipts(item_id, receipt_id) VALUES(0, 3);
INSERT INTO public.Items_Receipts(item_id, receipt_id) VALUES(1, 1);
INSERT INTO public.Items_Receipts(item_id, receipt_id) VALUES(2, 1);
-- Users_Receipts
INSERT INTO public.Users_Receipts(user_id, receipt_id) VALUES(0, 0);
INSERT INTO public.Users_Receipts(user_id, receipt_id) VALUES(0, 1);
INSERT INTO public.Users_Receipts(user_id, receipt_id) VALUES(0, 2);
INSERT INTO public.Users_Receipts(user_id, receipt_id) VALUES(0, 3);
INSERT INTO public.Users_Receipts(user_id, receipt_id) VALUES(1, 1);
INSERT INTO public.Users_Receipts(user_id, receipt_id) VALUES(2, 1);