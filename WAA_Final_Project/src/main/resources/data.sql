insert into role ( title)
values ('Admin');
insert into role ( title)
values ('Customer');
insert into role ( title)
values ('Owner');


insert into users (email, name, password, username, role_id)
values ('oaskhraim@gmail.com' , 'Omar Khraim' , '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'okh13', 1);
insert into users (email, name, password, username, role_id)
values ('mkiwan@yahoo.com' , 'Moh Kiwan' , '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'okh13', 2);


insert into public.address ( city, state, street, zip_code)
values ('Fairfield', 'Iowa', '4th street', 52557);
insert into public.address ( city, state, street, zip_code)
values ('IowaCity', 'Iowa', '6th street', 52240);
insert into public.address ( city, state, street, zip_code)
values ('Des Moines', 'Iowa', '8th street', 50047);



insert into property ( area_in_square_feet, bathroom_num, room_num, status,price, address_id, owner_id)
values (950, 2, 3, 1,35000, 1, 2);
insert into property ( area_in_square_feet, bathroom_num, room_num, status, price, address_id, owner_id)
values (950, 2, 3, 1,100000, 3, 2);
insert into property ( area_in_square_feet, bathroom_num, room_num, status, price, address_id, owner_id)
values (1200, 3, 2, 2,150000, 2, 2);


insert into offer (offer_description, status, agent_email, customer_id, property_id)
values (' Iam interested in apartment 1', 'pending','aboukham.abdelaziz@gmail.com', 2, 1);
