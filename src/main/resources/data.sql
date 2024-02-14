-- 5 USERS

INSERT INTO UserLogin.user_information_schema (first_name, last_name, email, password, user_name, profile_pic, role)
SELECT 'test', 'profile', 'test@example.com',  'pwd123', 'testUsername', 'https://randomren.com/images/faces-of-india/2008-10-14_IMG_9489.jpg', 'USER'
WHERE NOT EXISTS (
    SELECT * FROM UserLogin.user_information_schema WHERE email = 'test@example.com'
);

INSERT INTO UserLogin.user_information_schema (first_name, last_name, email, password, user_name, profile_pic, role)
SELECT 'Cooldude', 'Legend', 'Bro@example.com',  'pwd123', 'testUsername1', 'https://blenderartists.org/uploads/default/original/4X/f/7/a/f7a0a3a97695c83f4780973eb73b8f20ecc29df9.jpg','USER'
WHERE NOT EXISTS (
    SELECT * FROM UserLogin.user_information_schema WHERE email = 'test1@example.com'
);

INSERT INTO UserLogin.user_information_schema (first_name, last_name, email, password, user_name, profile_pic, role)
SELECT 'Jackie', 'Ligma', 'Jackie@example.com',  'pwd123', 'samename1', 'https://preview.redd.it/tried-to-generate-a-random-face-with-ai-now-i-have-to-worry-v0-indsbidh39la1.jpg?width=640&crop=smart&auto=webp&s=9020f96f8079f3518c6617f97a6362b2fbeb744b', 'USER'
WHERE NOT EXISTS (
    SELECT * FROM UserLogin.user_information_schema WHERE email = 'samename@example.com'
);

INSERT INTO UserLogin.user_information_schema (first_name, last_name, email, password, user_name, profile_pic, role)
SELECT 'Davine', 'Cole', 'davina@example.com',  'pwd123', 'Davina', 'https://1.img-dpreview.com/files/p/TS560x560~forums/63132016/2a1e59e12f4543bea10f2385259c81cf', 'USER'
WHERE NOT EXISTS (
    SELECT * FROM UserLogin.user_information_schema WHERE email = 'test2@example.com'
);

INSERT INTO UserLogin.user_information_schema (first_name, last_name, email, password, user_name, profile_pic, role)
SELECT 'Davine', 'Johnson', 'ladyluck@example.com',  'pwd123', 'Danny', 'https://discoverymood.com/wp-content/uploads/2020/04/Mental-Strong-Women-min.jpg', 'USER'
WHERE NOT EXISTS (
    SELECT * FROM UserLogin.user_information_schema WHERE email = 'ladyluck@example.com'
);

INSERT INTO UserLogin.user_information_schema (first_name, last_name, email, password, user_name, profile_pic, role)
SELECT 'Crazy', 'Dave', 'dave@example.com',  'pwd123', 'test3example', 'https://wink.messengergeek.com/uploads/default/original/2X/7/786d6dd4cc6df042c946e77da9146df8d2fadbfb.jpeg', 'USER'
WHERE NOT EXISTS (
    SELECT * FROM UserLogin.user_information_schema WHERE email = 'test3@example.com'
);


-- 
-- user 1 posts 

INSERT INTO UserLogin.user_posts (title, description, picture, user_id, date) VALUES ('Nasa is Opps part 1', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://i.natgeofe.com/n/5c7209e4-5de1-4bbb-9d3d-554f9472fc5e/01_spaceselfie__selfportrait_iss032_4288_3x2.jpg','1', "2024-02-05T12:45:30");

INSERT INTO UserLogin.user_posts (title, description, picture, user_id) VALUES ('Nasa is Opps part 3', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Buzz_Aldrin_self-photograph_during_Gemini_12_EVA_%28S66-62926%29.jpg/1200px-Buzz_Aldrin_self-photograph_during_Gemini_12_EVA_%28S66-62926%29.jpg','1');

INSERT INTO UserLogin.user_posts (title, description, picture, user_id, date) VALUES ('Nasa is Opps part 2', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://cached.imagescaler.hbpl.co.uk/resize/scaleWidth/815/cached.offlinehbpl.hbpl.co.uk/news/SUC/phoneinggg-20191028022225920.jpg','1', '2024-02-08T12:45:30');


-- 
-- user 2 posts

INSERT INTO UserLogin.user_posts (title, description, picture, user_id, date) VALUES ('I am usertwo part 1', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://pbs.twimg.com/profile_images/621416318080675840/EXN86ndr_400x400.jpg','2', "2024-02-05T12:45:30");

INSERT INTO UserLogin.user_posts (title, description, picture, user_id) VALUES ('I am usertwo part 3', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://pbs.twimg.com/profile_images/621416318080675840/EXN86ndr_400x400.jpg','2');

INSERT INTO UserLogin.user_posts (title, description, picture, user_id, date) VALUES ('I am usertwo part 2', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://pbs.twimg.com/profile_images/621416318080675840/EXN86ndr_400x400.jpg','2', '2024-02-08T12:45:30');

-- user 3 posts
INSERT INTO UserLogin.user_posts (title, description, picture, user_id) VALUES ('I am userthree part 2', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://c02.purpledshub.com/uploads/sites/48/2020/04/Things-never-knew-astronomy-e454e5d.jpg?w=1029&webp=1','3');

INSERT INTO UserLogin.user_posts (title, description, picture, user_id) VALUES ('I am userthree part 1', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://c02.purpledshub.com/uploads/sites/48/2020/04/Things-never-knew-astronomy-e454e5d.jpg?w=1029&webp=1','3');


-- user 4 posts
INSERT INTO UserLogin.user_posts (title, description, picture, user_id) VALUES ('I am userfour part 2', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://upload.wikimedia.org/wikipedia/commons/f/fc/Tarom.b737-700.yr-bgg.arp.jpg','4');

INSERT INTO UserLogin.user_posts (title, description, picture, user_id) VALUES ('I am userfour part 1', 'Its on sight, NASA. Pagans left me in orbit on God my team cheffin you up dont try hidin michael. No-one safe fuck yall you lucky I aint down, you know I fucked yo bitch M das why you done this. Bitch nigga your life is moot my day ones on standby you dont know me what i did to get here yall niggas thik ni got ma government, clapped mfuckers i was shottin the whole time wastemans got no ends, no postcode niggas. Times up', 'https://upload.wikimedia.org/wikipedia/commons/f/fc/Tarom.b737-700.yr-bgg.arp.jpg','4');


-- 
-- inserting friends
INSERT INTO UserLogin.user_friend (user_id, friend_id) VALUES (1, 2);
INSERT INTO UserLogin.user_friend (user_id, friend_id) VALUES (1, 3);
INSERT INTO UserLogin.user_friend (user_id, friend_id) VALUES (1, 4);
INSERT INTO UserLogin.user_friend (user_id, friend_id) VALUES (1, 5);

INSERT INTO UserLogin.user_friend (user_id, friend_id) VALUES (2, 1);
INSERT INTO UserLogin.user_friend (user_id, friend_id) VALUES (2, 3);

-- inserting friend requests into the test user
INSERT INTO UserLogin.user_follower_requests (user_id, requester_user_id) VALUES (1, 2);
INSERT INTO UserLogin.user_follower_requests (user_id, requester_user_id) VALUES (1, 3);
INSERT INTO UserLogin.user_follower_requests (user_id, requester_user_id) VALUES (1, 4);
-- inserting friend requests into the cool user
INSERT INTO UserLogin.user_follower_requests (user_id, requester_user_id) VALUES (2, 1);
INSERT INTO UserLogin.user_follower_requests (user_id, requester_user_id) VALUES (2, 5);
INSERT INTO UserLogin.user_follower_requests (user_id, requester_user_id) VALUES (2, 6);

