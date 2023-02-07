insert into role ( title)
values ('Admin');
insert into role ( title)
values ('Customer');
insert into role ( title)
values ('Owner');


insert into users (email, name, password, username, role_id)
values ('oaskhraim@gmail.com' , 'Omar Khraim' , '5555', 'okh13', 1);
insert into users (email, name, password, username, role_id)
values ('mkiwan@yahoo.com' , 'Moh Kiwan' , '5555', 'okh13', 2);


insert into public.address ( city, state, street, zip_code)
values ('Fairfield', 'Iowa', '4th street', 52557);


insert into property ( area_in_square_feet, bathroom_num, room_num, status,price, address_id, owner_id)
values (950, 2, 3, 1,35000, 1, 2);