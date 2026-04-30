DELETE FROM orders;
DELETE FROM feedback;
DELETE FROM car;
DELETE FROM page;

--страницы
INSERT INTO page (title, slug, content) VALUES
('Контакты', 'contacts', 'Телефон: +75675674537, Email: info@cars.com'),
('Галерея', 'gallery', 'Галерея автомобилей'),
('Обратная связь', 'feedback', 'Напишите нам'),
('О нас', 'about', 'Мы лучшая компания по аренде автомобилей');

--машины
INSERT INTO car (name, price, image) VALUES
('BMW', 50, '/images/car1.jpg'),
('Audi', 45, '/images/car2.jpg'),
('Mercedes', 70, '/images/car3.jpg');

--отзывы
INSERT INTO feedback (name, message, car_id) VALUES
('Иван', 'Отличный сервис!', 1),
('Анна', 'Все понравилось!', 2);

--заявки
INSERT INTO orders (name, phone, car_id) VALUES
('Петр', '+74869375937', 1),
('Мария', '+73495738502', 2);