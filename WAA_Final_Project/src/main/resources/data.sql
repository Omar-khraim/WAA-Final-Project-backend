insert into role (title)
values ('Admin');
insert into role (title)
values ('Customer');
insert into role (title)
values ('Owner');


insert into users (email, name, password, username, role_id)
values ('oaskhraim@gmail.com', 'Omar Khraim', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'okh13',
        3);
insert into users (email, name, password, username, role_id)
values ('mkiwan@yahoo.com', 'Moh Kiwan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'okh13', 2);

insert into users (email, name, password, username, role_id)
values ('kiki@yahoo.com', 'Kiwan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'kiki', 2);


insert into public.address (city, state, street, zip_code)
values ('Fairfield', 'Iowa', '4th street', 52557);
insert into public.address (city, state, street, zip_code)
values ('IowaCity', 'Iowa', '6th street', 52240);
insert into public.address (city, state, street, zip_code)
values ('Des Moines', 'Iowa', '8th street', 50047);



insert into property (area_in_square_feet, bathroom_num, room_num, status, price, address_id, owner_id)
values (950, 2, 3, 1, 35000, 1, 1);
insert into property (area_in_square_feet, bathroom_num, room_num, status, price, address_id, owner_id)
values (950, 2, 3, 1, 100000, 3, 1);
insert into property (area_in_square_feet, bathroom_num, room_num, status, price, address_id, owner_id)
values (1200, 3, 2, 2, 150000, 2, 1);


-- insert into offer (offer_description, status, agent_email, customer_id, property_id)
-- values (' Iam interested in apartment 1', 'pending','aboukham.abdelaziz@gmail.com', 2, 1);
-- insert into offer (agent_email, credit_score, offer_amount, offer_description, offer_type, status, property_id,
--                    customer_id)
-- values ('', 500, 5000, 'i want your house', 'house', 1, 2, 2);
-- values ('', 600, 4900, 'i want your house too ', 'house', 1, 2, 1);

INSERT INTO public.offer ( agent_email, credit_score, offer_amount, offer_description, offer_type, status, property_id, user_id)
VALUES ( null, 500, 500, 'mkiwan offer', '', 0, 1, 2);
INSERT INTO public.offer ( agent_email, credit_score, offer_amount, offer_description, offer_type, status, property_id, user_id)
VALUES ( null, 600, 600, 'mkiwan offer', '', 0, 2, 2);
INSERT INTO public.offer ( agent_email, credit_score, offer_amount, offer_description, offer_type, status, property_id, user_id)
VALUES ( null, 660, 123456, 'kiki offer', '', 0, 1, 3);


insert into likes (property_id, users_id)
values (1, 1);
insert into likes (property_id, users_id)
values (1, 2);
insert into likes (property_id, users_id)
values (2, 1);
insert into likes (property_id, users_id)
values (2, 2);