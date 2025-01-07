INSERT INTO public.brand(
	id, description, name, image)
	VALUES (1, 'Camionetas', 'ZX', 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732120577/logo-zxauto-h_e0r3ov.png'),
    (2, 'Vehiculos comerciales', 'KYC', 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732129156/logo_kyc_ikbdj6.webp'),
    (3, 'Vehiculo de pasajeros', 'LIVAN', 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732129239/Livan-logo_vytyah.png'),
    (4, 'Vehiculo de pasajeros y Vehiculos comerciales', 'FAW', 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732129417/logo_faw_fd9med.png'),
    (5, 'Vehiculo de pasajeros y Vehiculos comerciales', 'LIFAN', 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732129539/Lifan-logo_cnc24e.png'),
    (6, 'Vehiculos comerciales', 'DFCA', 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732129707/logo_dongfeng_puhu1h.png'),
    (7, 'Vehiculo de pasajeros', 'Link & Co', 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732130778/link_co_rn5cri.png'),
    (8, 'Camioneta electrica', 'Riddara', 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732130941/riddata_logo_ezsaem.png'),
    (9, 'Motos', 'Lifan Motos', 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732129539/Lifan-logo_cnc24e.png');

INSERT INTO public.category(
	id, name)
	VALUES (1, 'SISTEMA DE MOTOR'),
    (2, 'SISTEMA DE TRANSMISION'),
    (3, 'SISTEMA DE CHASIS'),
    (4, 'AIRE ACONDICIONADO'),
    (5, 'SISTEMA ELECTRONICO'),
    (6, 'CARROCERIA Y ACCESORIOS'),
    (7, 'INTERIOR'),
    (8, 'CARGO');

INSERT INTO public.concessionaire(
	id, name)
	VALUES (1, 'Forcenter'),
    (2, 'Maritano'),
    (3, 'Grass'),
    (4, 'Red autos');

INSERT INTO public.concessionaire_brand(
	brand_id, concessionaire_id)
	VALUES (8, 1),
	(7, 1),
	(6, 1),
	(5, 1),
	(4, 1),
	(3, 1),
	(2, 1),
	(1, 1),
	(7, 2),
	(6, 2);

INSERT INTO public.model(
    id, description, name, brand_id, image)
    VALUES (1, '1.5', 'T3', 1, 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732198745/T3_gdsxqs.png'),
   (2, '1.6', 'T3', 1, 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732198745/T3_gdsxqs.png'),
   (3, '1.5', 'X5', 1, 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732199948/kyc-x5_bxnqrk.png'),
   (4, '1.8', 'X5 PLUS', 1, 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732200032/KYC-X5-PLUS_qmnm76.png'),
   (5, 'DLX 4X4', 'Terralord', 2, 'https://res.cloudinary.com/dmznj1w51/image/upload/v1732200138/zxauto-terralord_zyqktl.png');

INSERT INTO public.users(
	id, data_time_create, account_no_expired, account_no_locked, credential_no_expired, is_enable, password, username)
	VALUES (1, NOW(), true, true, true, true, '$2a$10$nbUS.NBQi9M87Zd/Hw3qzOnuvB314pia8WHLxMdu13ak4qtwYlmx2', 'Andy'?),
	(2, NOW(), true, true, true, true, '$2a$10$nbUS.NBQi9M87Zd/Hw3qzOnuvB314pia8WHLxMdu13ak4qtwYlmx2', 'Cristian'),
	(3, NOW(), true, true, true, true, '$2a$10$nbUS.NBQi9M87Zd/Hw3qzOnuvB314pia8WHLxMdu13ak4qtwYlmx2', 'David');