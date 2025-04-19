----SUBJECT
insert into subjects (id, title_uz, title_ru, created_at, updated_at)
values (1, 'Kimyo', 'Химия', now(), now()),
       (2, 'Biologiya', 'Биология', now(), now());

alter sequence subjects_id_seq restart with 3;
----SUBJECT

----TOPIC
-- 1-MODULE
insert into topics (id, subject_id, next_id, seq, title_uz, title_ru, created_at, updated_at)
values (1, 1, 2, 1, 'Umumiy kimyo', 'Общая химия', now(), now());

insert into topics (id, subject_id, prev_id, next_id, parent_id, seq, title_uz, title_ru, created_at, updated_at)
values
        (2, 1, 1, 3, 1, 1, 'Kimyoning asosiy tushunchalari', 'Основные понятия химии', now(), now()),
            (3, 1, 2, 4, 2, 1, 'Atom-molekular ta''limot. Kimyoviy element. Kimyoviy belgi', 'Атомно-молекулярная теория. Химический элемент. Химический символ', now(), now()),
            (4, 1, 3, 5, 2, 2, 'Atomlarning o''lchami. Nisbiy va absolut atom massa', 'Размер атомов. Относительная и абсолютная атомная масса', now(), now()),
            (5, 1, 4, 6, 2, 3, 'Molekular va nomolekular tuzilishdagi moddalar', 'Вещества молекулярного и немолекулярного строения', now(), now()),
            (6, 1, 5, 7, 2, 4, 'Oddiy va murakkab modda. Allotropiya', 'Простое и сложное вещество. Аллотропия', now(), now()),
            (7, 1, 6, 8, 2, 5, 'Moddalarning agregat holatlari', 'Агрегатные состояния веществ', now(), now()),
            (8, 1, 7, 9, 2, 6, 'Kimyoviy formula va undan kelib chiqadigan xulosalar. Valentlik. Indeks', 'Химическая формула и ее выводы. Валентность. Индекс', now(), now()),
            (9, 1, 8, 10, 2, 7, 'Sof modda va aralashma. Gomogen va geterogen aralashma', 'Чистое вещество и смесь. Гомогенная и гетерогенная смесь', now(), now()),
            (10, 1, 9, 11, 2, 8, 'Molekulalarning o''lchami, nisbiy va absolut massasi. Modda miqdori - mol. Molar massa. Avogadro doimiysi', 'Размер молекул, относительная и абсолютная масса. Количество вещества - моль. Молярная масса. Постоянная Авогадро', now(), now()),
            (11, 1, 10, 12, 2, 9, 'Fizik va kimyoviy o''zgarishlar', 'Физические и химические изменения', now(), now()),
            (12, 1, 11, 13, 2, 10, 'Kimyoviy reaksiyaning sodir bo''lishi. Kimyoviy reaksiyalar tenglamalari, koeffitsientlar', 'Возникновение химической реакции. Уравнения химических реакций, коэффициенты', now(), now()),

        (13, 1, 12, 14, 1, 2, 'Kimyoning asosiy stexiometrik qonunlari', 'Основные стехиометрические законы химии', now(), now()),
            (14, 1, 13, 15, 13, 1, 'Massaning saqlanish, tarkibning doimiylik, karrali nisbatlar va Avogadro qonunlari', 'Сохранение массы, постоянство состава, кратные отношения и законы Авогадро', now(), now()),
            (15, 1, 14, 16, 13, 2, 'Molar hajm, gaz qonunlari, Mendeleyev-Klapeyron tenglamasi', 'Молярный объем, газовые законы, уравнение Менделеева-Клапейрона', now(), now()),
            (16, 1, 15, 17, 13, 3, 'Ekvivalent va ekvivalentlik qonuni, ekvivalent massa, ekvivalent miqdor', 'Эквивалент и закон эквивалентности, эквивалентная масса, эквивалентное количество', now(), now()),
            (17, 1, 16, 18, 13, 4, 'Gaz aralashmasi, gazlarning molar hajmi, gazning hajm ulushi, zichligi va nisbiy zichligi', 'Газовая смесь, мольный объем газов, объемная доля газа, плотность и относительная плотность', now(), now()),
            (18, 1, 17, 19, 13, 5, 'Kimyoviy reaksiya turlari. Birikish, parchalanish, o''rin olish, almashinish reaksiyalari', 'Виды химических реакций. Сцепление, распад, вытеснение, реакции обмена', now(), now()),
            (19, 1, 18, 20, 13, 6, 'Reaksiyaning issiqlik miqdori, ekzotermik, endotermik reaksiyalar', 'Количество теплоты реакции, экзотермических, эндотермических реакций', now(), now()),
            (20, 1, 19, 21, 13, 7, 'Murakkab moddalar tarkibidagi elementlarning massa ulushlarini hisoblash', 'Расчет массовых долей элементов в соединениях', now(), now()),
            (21, 1, 20, 22, 13, 8, 'Modda tarkibidagi elementlarning miqdoriy nisbatlari aniq bo''lganda modda formulasini topish', 'Нахождение формулы вещества, когда ясны количественные соотношения элементов в веществе', now(), now()),
            (22, 1, 21, 23, 13, 9, 'Kimyoviy reaksiyalar asosida hisoblashlar, reaksiya unumi', 'Расчеты на основе химических реакций, продуктов реакции', now(), now()),

        (23, 1, 22, 24, 1, 3, 'Davriy qonun va davriy sistema. Atom tuzilishi', 'Периодический закон и периодическая система. Структура атома', now(), now()),
            (24, 1, 23, 25, 23, 1, 'Davriy qonun va davriy sistema', 'Периодический закон и периодическая система', now(), now()),
            (25, 1, 24, 26, 23, 2, 'Atom tuzilishi, atom yadrosi tarkibi, izotop, izoton, izobar va izoelektronlar', 'Атомная структура, состав атомного ядра, изотоп, изотон, изобара и изоэлектроны', now(), now()),
            (26, 1, 25, 27, 23, 3, 'Atom elektron qavatlarining tuzilishi, energetik pog''onalar, energetik pog''onachalar, elektron konfiguratsiya', 'Структура атомных электронных слоев, энергетические уровни, энергетические подуровни, электронная конфигурация', now(), now()),
            (27, 1, 26, 28, 23, 4, 'Kvant sonlar, Klechkovskiy qoidasi, Pauli prinsipi, Gund qoidasi', 'Квантовые числа, правило Клечковского, принцип Паули, правило Гунда', now(), now()),
            (28, 1, 27, 29, 23, 5, 'Yadro reaksiyalari, alfa, betta, gamma - nurlanishlar. Davr va guruhlarda elementlar xossalarining o''zgarishi, davriy xossalar', 'Ядерные реакции, альфа, бета, гамма-излучение. Изменение свойств элементов по периодам и группам, периодические свойства', now(), now()),

        (29, 1, 28, 30, 1, 4, 'Kimyoviy bog''lanish turlari. Kristall panjaralar', 'Виды химических связей. Кристаллические решетки', now(), now()),
            (30, 1, 29, 31, 29, 1, 'Kimyoviy bog''lanishlar. Bog'' xossasi', 'Химические связи. Свойства связи', now(), now()),
            (31, 1, 30, 32, 29, 2, 'Kimyoviy bog''lanishlar energiyasi, bog''lanish uzunligi, valent burchak, bog''lanish tartibi', 'Энергия химической связи, длина связи, валентный угол, порядок связи', now(), now()),
            (32, 1, 31, 33, 29, 3, 'Bog''lanish turlari: kovalent (qutbli va qutbsiz, donor - akseptor), metall, ionli, vodorod', 'Виды связей: ковалентная (полярная и неполярная, донорно-акцепторная), металлическая, ионная, водородная', now(), now()),
            (33, 1, 32, 34, 29, 4, 'Kristall panjara turlari, kristall va amorf moddalar, tuzilish formulalari, sigma- va pi-bog''lanishlar', 'Типы кристаллических решеток, кристаллические и аморфные вещества, структурные формулы, сигма- и пи-связи', now(), now()),

        (34, 1, 33, 35, 1, 5, 'Kimyoviy reaksiyalarning kinetikasi. Kimyoviy muvozanat', 'Кинетика химических реакций. Химическое равновесие', now(), now()),
            (35, 1, 34, 36, 34, 1, 'Reaksiya tezligi va unga ta''sir etuvchi omillar (modda tabiati, gaz va suyuq moddalar konsentratsiyasi, bosim, hajm, harorat)', 'Скорость реакции и факторы, влияющие на нее (природа вещества, концентрация газообразных и жидких веществ, давление, объем, температура)', now(), now()),
            (36, 1, 35, 37, 34, 2, 'Kataliz va katalizator. Fermentlar, ingibitor haqida tushuncha', 'Катализ и катализатор. Понятие о ферментах, ингибиторе', now(), now()),
            (37, 1, 36, 38, 34, 3, 'Qaytar va qaytmas reaksiyalar, to''g''ri va teskari reaksiyalar', 'Обратимые и необратимые реакции, прямые и обратные реакции', now(), now()),
            (38, 1, 37, 39, 34, 4, 'Kimyoviy muvozanat va uning siljishi. Le-Shatelye prinsipi', 'Химическое равновесие и его сдвиг. Принцип Ле Шателье', now(), now()),
            (39, 1, 38, 40, 34, 5, 'Kimyoviy muvozanatga bosimning, konsentratsiyaning va haroratning ta''siri', 'Влияние давления, концентрации и температуры на химическое равновесие', now(), now()),

        (40, 1, 39, 41, 1, 6, 'Eritmalar', 'Растворы', now(), now()),
            (41, 1, 40, 42, 40, 1, 'Eritmaning aralashma va kimyoviy birikma bilan o''xshashligi va farqi', 'Сходства и различия раствора со смесью и химического соединения', now(), now()),
            (42, 1, 41, 43, 40, 2, 'Eritma tarkibidagi erigan modda miqdoriga ko''ra eritmalarning turlari', 'Виды растворов по количеству растворенного вещества в растворе', now(), now()),
            (43, 1, 42, 44, 40, 3, 'Eritmalar konsentratsiyalarini ifodalash usullari (massa ulush, foiz konsentratsiya, molar va normal konsentratsiyalar)', 'Методы выражения концентраций растворов (массовая доля, процентная концентрация, молярная и нормальная концентрации)', now(), now()),
            (44, 1, 43, 45, 40, 4, 'Foiz va molar, foiz va normal konsentratsiya o''rtasidagi bog''lanish', 'Связь между процентом и молярной, процентом и нормальной концентрацией', now(), now()),
            (45, 1, 44, 46, 40, 5, 'Eruvchanlik koeffitsiyenti', 'Коэффициент растворимости', now(), now()),
            (46, 1, 45, 47, 40, 6, 'To''yingan, to''yinmagan, o''ta to''yingan eritmalar', 'Насыщенные, ненасыщенные, пересыщенные растворы', now(), now()),
            (47, 1, 46, 48, 40, 7, 'Kristallogidratlar', 'Кристаллогидраты', now(), now()),
            (48, 1, 47, 49, 40, 8, 'Kimyoviy moddalarning amaliy ahamiyati', 'Практическое значение химических веществ', now(), now()),

        (49, 1, 48, 50, 1, 7, 'Elektrolitik dissotsiatsiyalanish nazariyasi', 'Теория электролитической диссоциации', now(), now()),
            (50, 1, 49, 51, 49, 1, 'Elektrolitik dissotsiatsiyalanish nazariyasi. Elektrolitlar va noelektrolitlar', 'Теория электролитической диссоциации. Электролиты и неэлектролиты', now(), now()),
            (51, 1, 50, 52, 49, 2, 'Kislota, ishqor va tuzlarning dissotsiatsiyalanishi', 'Диссоциация кислоты, щелочи и солей', now(), now()),
            (52, 1, 51, 53, 49, 3, 'Elektrolitlarning dissotsiatsiyalanish darajasi', 'Степень диссоциации электролитов', now(), now()),
            (53, 1, 52, 54, 49, 4, 'Ionlar: kation va anionlar', 'Ионы: катионы и анионы', now(), now()),
            (54, 1, 53, 55, 49, 5, 'Kuchli va kuchsiz elektrolitlar', 'Сильные и слабые электролиты', now(), now()),
            (55, 1, 54, 56, 49, 6, 'Dissotsiatsiyalanish konstantasi, ion almashinish reaksiyalari, qisqa va to''liq ionli tenglamalar', 'Константа диссоциации, реакции ионного обмена, краткие и полные ионные уравнения', now(), now()),
            (56, 1, 55, 57, 49, 7, 'Suvning ion ko''paytmasi, pH va pOH', 'Ионное произведение воды, pH и pOH', now(), now()),
            (57, 1, 56, 58, 49, 8, 'Tuzlar gidrolizi, tuzlar gidrolizlanganda sodir bo''ladigan jarayonlar va undagi eritma muhiti', 'Гидролиз солей, процессы, происходящие при гидролизе солей и среда их растворения', now(), now()),

        (58, 1, 57, 59, 1, 8, 'Oksidlanish-qaytarilish reaksiyalari', 'Окислительно-восстановительные реакции', now(), now()),
            (59, 1, 58, 60, 58, 1, 'Oksidlanish darajasi', 'Уровень окисления', now(), now()),
            (60, 1, 59, 61, 58, 2, 'Oksidlanish-qaytarilish reaksiyalari (oksidlanish hamda qaytarilish jarayonlari, oksidlovchi va qaytaruvchilar)', 'Окислительно-восстановительные реакции (процессы окисления и восстановления, окислители и восстановители)', now(), now()),
            (61, 1, 60, 62, 58, 3, 'Oksidlanish-qaytarilish reaksiyalarini tenglash usullari – elektron balans va yarim reaksiya usuli', 'Методы балансирования окислительно-восстановительных реакций – электронный баланс и метод полуреакций', now(), now()),

        (62, 1, 61, 63, 1, 9, 'Elektroliz', 'Электролиз', now(), now()),
            (63, 1, 62, 64, 62, 1, 'Elektroliz va unda sodir bo''ladigan jarayonlar', 'Электролиз и процессы, происходящие в нем', now(), now()),
            (64, 1, 63, 65, 62, 2, 'Katod va anod, inert elektrodlar, eruvchan va erimaydigan anodlar', 'Катод и анод, инертные электроды, растворимые и нерастворимые аноды', now(), now()),
            (65, 1, 64, 66, 62, 3, 'Faradey soni. Eritma va suyuqlanma elektrolizi', 'Число Фарадея. Электролиз раствора и сжижения', now(), now()),
            (66, 1, 65, 67, 62, 4, 'Katodda sodir bo''ladigan qaytarilish jarayoni, anodda sodir bo''ladigan oksidlanish jarayoni', 'Процесс восстановления, происходящий на катоде, процесс окисления, происходящий на аноде', now(), now()),
            (67, 1, 66, 68, 62, 5, 'Metallarning aktivlik qatori. Elektrolizga doir Faradey qonunlari', 'Ряд активности металлов. Законы электролиза Фарадея', now(), now());

-- 2-MODULE
insert into topics (id, subject_id, prev_id, next_id, seq, title_uz, title_ru, created_at, updated_at)
values (68, 1, 67, 69, 2, 'Anorganik kimyo', 'Неорганическая химия', now(), now());

insert into topics (id, subject_id, prev_id, next_id, parent_id, seq, title_uz, title_ru, created_at, updated_at)
values
        (69, 1, 68, 70, 68, 1, 'Anorganik moddalarning eng muhim sinflari', 'Важнейшие классы неорганических веществ', now(), now()),
            (70, 1, 69, 71, 69, 1, 'Oksidlarning tarkibi, tuzilishi, nomlanishi va ularning turlari; olinish usullari va xossalari', 'Состав, строение, наименование и типы оксидов; методы получения и свойства', now(), now()),
            (71, 1, 70, 72, 69, 2, 'Asoslarning tarkibi, tuzilishi, nomlanishi va ularning turlari; olinish usullari va xossalari', 'Состав, структура, наименование и типы оснований; методы получения и свойства', now(), now()),
            (72, 1, 71, 73, 69, 3, 'Kislotalarning tarkibi, tuzilishi, nomlanishi va turlari; olinish usullari va xossalari', 'Состав, строение, наименование и типы кислот; методы получения и свойства', now(), now()),
            (73, 1, 72, 74, 69, 4, 'Tuzlarning tarkibi, tuzilishi, nomlanishi va ularning turlari; olinish usullari va xossalari', 'Состав, строение, наименование солей и их типы; методы получения и свойства', now(), now()),
            (74, 1, 73, 75, 69, 5, 'Eng muhim oksidlar, asoslar, kislotalar va tuzlarning ishlatilishi', 'Наиболее важные области применения оксидов, оснований, кислот и солей', now(), now()),
            (75, 1, 74, 76, 69, 6, 'Anorganik moddalarning eng muhim sinflari o''rtasidagi genetik bog''lanish', 'Генетические связи между важнейшими классами неорганических веществ', now(), now()),

        (76, 1, 75, 77, 68, 2, 'Metallmaslar', 'Неметаллы', now(), now()),
            (77, 1, 76, 78, 76, 1, 'Metallmaslarning davriy sistemada joylashishi, tabiatda tarqalishi, metallmaslarning tabiiy oilalari, olinish usullari va ishlatilishi', 'Размещение неметаллов в периодической системе, распространение в природе, естественные семейства металлов, способы получения и использования', now(), now()),
            (78, 1, 77, 79, 76, 2, 'Metallmaslarning fizik va kimyoviy xossalari, ularning birikmalari', 'Физико-химические свойства неметаллов, их соединений', now(), now()),
            (79, 1, 78, 80, 76, 3, 'Kislorod va uning izotoplari, allotropiyasi, olinish usullari va xossalari', 'Кислород и его изотопы, аллотропия, способы получения и свойства', now(), now()),
            (80, 1, 79, 81, 76, 4, 'Vodorod va uning izotoplari, olinish usullari va xossalari', 'Водород и его изотопы, способы получения и свойства', now(), now()),
            (81, 1, 80, 82, 76, 5, 'Uglerod va uning eng muhim birikmalari, uglerod guruhchasi metallmaslari', 'Углерод и его важнейшие соединения, металлы углеродной подгруппы', now(), now()),
            (82, 1, 81, 83, 76, 6, 'Azot va uning birikmalari, nitrat kislotani olinish usullari hamda xossalari, nitratlar, azot guruhchasi metallmaslari', 'Азот и его соединения, способы и свойства производства азотной кислоты, нитраты, неметаллы азотной группы', now(), now()),
            (83, 1, 82, 84, 76, 7, 'Xalkogenlar, oltingugurt va oltingugurt birikmalarining xossalari, sulfat kislotaning olinish usullari hamda xossalari, oleum. Sulfat va nitrat kislotalarni sanoatda ishlab chiqarish', 'Свойства халькогенов, серы и сернистых соединений, способы получения и свойства серной кислоты, олеума. Промышленное производство серной и азотной кислот', now(), now()),
            (84, 1, 83, 85, 76, 8, 'Galogenlar va nodir gazlar, ularning tabiatda tarqalishi, olinish usullari hamda xossalari', 'Галогены и редкие газы, их распространение в природе, способы получения и свойства', now(), now()),
            (85, 1, 84, 86, 76, 9, 'Mineral o''g''itlar. Makro va mikroelementlar, oddiy va kompleks o''g''itlar. Azotli, fosforli va kaliyli o''g''itlar, ularda ozuqa elementining miqdorini hisoblash. Biogen elementlar va ularning tirik organizmlardagi ahamiyati', 'Минеральные удобрения. Макро- и микроэлементы, простые и сложные удобрения. Азотные, фосфорные и калийные удобрения, расчет количества в них питательных веществ. Биогенные элементы и их значение в живых организмах', now(), now()),

        (86, 1, 85, 87, 68, 3, 'Metallar', 'Металлы', now(), now()),
            (87, 1, 86, 88, 86, 1, 'Metallarning davriy jadvaldagi o''rni, tabiatda tarqalishi, olinish usullari va ishlatilshi', 'Место металлов в таблице Менделеева, распространение в природе, способы добычи и использования', now(), now()),
            (88, 1, 87, 89, 86, 2, 'Metallarning fizik va kimyoviy xossalari, ularning birikmalari', 'Физико-химические свойства металлов, их соединений', now(), now()),
            (89, 1, 88, 90, 86, 3, 'Ishqoriy va ishqoriy-yer metallar. Ularning olinish usullari, xossalari, birikmalari va ishlatilishi', 'Щелочные и щелочноземельные металлы. Способы их получения, свойства, соединения и применение', now(), now()),
            (90, 1, 89, 91, 86, 4, 'Suvning qattiqligi va uni yo''qotish usullari', 'Жесткость воды и способы ее устранения', now(), now()),
            (91, 1, 90, 92, 86, 5, 'Aluminiy', 'Алюминий', now(), now()),
            (92, 1, 91, 93, 86, 6, 'I guruhning yonaki guruhchasi (Cu, Ag, Au)', 'Боковая группа I группы (Cu, Ag, Au)', now(), now()),
            (93, 1, 92, 94, 86, 7, 'II guruhning yonaki guruhchasi elementlari (Zn, Cd, Hg)', 'Элементы боковой группы II группы (Zn, Cd, Hg)', now(), now()),
            (94, 1, 93, 95, 86, 8, 'Xrom, marganes, temir metallarining xossalari, ularning eng asosiy birikmalarining olinishi, xossalari, ishlatilishi', 'Свойства металлов хрома, марганца, железа, получение их основных соединений, свойства, применение', now(), now()),
            (95, 1, 94, 96, 86, 9, 'Metallar korroziyasi va ularni korroziyadan himoyalash usullari', 'Коррозия металлов и методы защиты их от коррозии', now(), now()),
            (96, 1, 95, 97, 86, 10, 'Qotishmalar. Cho''yan va po''lat ishlab chiqarish', 'Сплавы. Производство чугуна и стали', now(), now()),
            (97, 1, 96, 98, 86, 11, 'Kompleks birikmalar', 'Комплексные соединения', now(), now());

-- 3-MODULE
insert into topics (id, subject_id, prev_id, next_id, seq, title_uz, title_ru, created_at, updated_at)
values (98, 1, 97, 99, 3, 'Organik kimyo', 'Органическая химия', now(), now());

insert into topics (id, subject_id, prev_id, next_id, parent_id, seq, title_uz, title_ru, created_at, updated_at)
values
        (99, 1, 98, 100, 98, 1, 'Organik kimyoning asosiy tushuncha va qonunlari. To''yingan uglevodorodlar', 'Основные понятия и законы органической химии. Насыщенные углеводороды', now(), now()),
            (100, 1, 99, 101, 99, 1, 'Organik kimyoning asosiy tushuncha va qonunlari. Organik birikmalarning o''ziga xos xususiyatlari', 'Основные понятия и законы органической химии. Особые свойства органических соединений', now(), now()),
            (101, 1, 100, 102, 99, 2, 'A.M.Butlerovning organik birikmalarning kimyoviy tuzilish nazariyasi', 'Теория химического строения органических соединений А.М. Бутлерова', now(), now()),
            (102, 1, 101, 103, 99, 3, 'Organik birikmalarning sinflanishi', 'Классификация органических соединений', now(), now()),
            (103, 1, 102, 104, 99, 4, 'Organik birikmalarga xos reaksiya turlari, izomeriya va uning turlari', 'Типы реакций, характерные для органических соединений, изомерия и ее виды', now(), now()),
            (104, 1, 103, 105, 99, 5, 'To''yingan uglevodorodlar', 'Насыщенные углеводороды', now(), now()),
            (105, 1, 104, 106, 99, 6, 'Alkanlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Алканы. Их строение, гомологический ряд, изомерия, номенклатура, способы получения, свойства и применение', now(), now()),
            (106, 1, 105, 107, 99, 7, 'Sikloalkanlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Циклоалканы. Их строение, гомологический ряд, изомерия, номенклатура, способы получения, свойства и применение', now(), now()),

        (107, 1, 106, 108, 98, 2, 'To''yinmagan uglevodorodlar', 'Ненасыщенные углеводороды', now(), now()),
            (108, 1, 107, 109, 107, 1, 'Alkenlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Алкены. Их строение, гомологический ряд, изомерия, номенклатура, способы получения, свойства и применение', now(), now()),
            (109, 1, 108, 110, 107, 2, 'Alkadiyenlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Алкадиены. Их строение, гомологический ряд, изомерия, номенклатура, способы получения, свойства и применение', now(), now()),
            (110, 1, 109, 111, 107, 3, 'Alkinlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Алкины. Их строение, гомологический ряд, изомерия, номенклатура, способы получения, свойства и применение', now(), now()),
            (111, 1, 110, 112, 107, 4, 'Aromatik uglevodorodlarning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Строение, ряд гомологии, изомерия, номенклатура, способы получения, свойства и применение ароматических углеводородов', now(), now()),
            (112, 1, 111, 113, 107, 5, 'Organik birikmalarda uglerod atomining gibridlanishi', 'Гибридизация атома углерода в органических соединениях', now(), now()),
            (113, 1, 112, 114, 107, 6, 'Uglevodorodlarning tabiiy manbalari. Neft, tabiiy gaz va toshko''mir', 'Природные источники углеводородов. Нефть, природный газ и уголь', now(), now()),

        (114, 1, 113, 115, 98, 3, 'Kislorodli organik birikmalar', 'Кислородсодержащие органические соединения', now(), now()),
            (115, 1, 114, 116, 114, 1, 'To''yingan bir atomli va ko''p atomli spirtlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Насыщенные одноатомные и многоатомные спирты. Их строение, гомологический ряд, изомерия, номенклатура, способы получения, свойства и применение', now(), now()),
            (116, 1, 115, 117, 114, 2, 'Fenollar va aromatik spirtlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Фенолы и ароматические спирты. Их строение, гомологический ряд, изомерия, номенклатура, способы получения, свойства и применение', now(), now()),
            (117, 1, 116, 118, 114, 3, 'Aldegidlar va ketonlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Альдегиды и кетоны. Их строение, гомологический ряд, изомерия, номенклатура, способы получения, свойства и применение', now(), now()),

        (118, 1, 117, 119, 98, 4, 'Karbon kislotalar, efirlar va uglevodlar', 'Карбоновые кислоты, эфиры и углеводы', now(), now()),
            (119, 1, 118, 120, 118, 1, 'Karbon kislotalar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, tabiatda tarqalishi, olinish usullari, xossalari hamda ishlatilishi', 'Карбоновые кислоты. Их строение, гомологический ряд, изомерия, номенклатура, распространение в природе, способы получения, свойства и применение', now(), now()),
            (120, 1, 119, 121, 118, 2, 'Oddiy va murakkab efirlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, tabiatda tarqalishi, olinish usullari, xossalari hamda ishlatilishi', 'Простые и сложные эфиры. Их строение, гомологический ряд, изомерия, номенклатура, распространение в природе, способы получения, свойства и применение', now(), now()),
            (121, 1, 120, 122, 118, 3, 'Yog''lar, sovun va yuvish vositalari. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, tabiatda tarqalishi, olinish usullari, xossalari hamda ishlatilishi', 'Масла, мыло и моющие средства. Их строение, гомологический ряд, изомерия, номенклатура, распространение в природе, способы получения, свойства и применение', now(), now()),
            (122, 1, 121, 123, 118, 4, 'Uglevodlar. Monosaxaridlar, disaxaridlar, polisaxaridlarning tuzilishi, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'Углеводы. Строение, изомерия, номенклатура, способы получения, свойства и применение моносахаридов, дисахаридов, полисахаридов', now(), now()),

        (123, 1, 122, 124, 98, 5, 'Azotli organik birikmalar. Yuqori molekulyar birikmalar', 'Азотные органические соединения. Высокомолекулярные соединения', now(), now()),
            (124, 1, 123, 125, 123, 1, 'Nitrobirikmalar va aminlar. Ularning tuzilishi, nomenklaturasi, olinishi, xossalari va ishlatilishi', 'Нитросоединения и амины. Их строение, номенклатура, получение, свойства и применение', now(), now()),
            (125, 1, 124, 126, 123, 2, 'Aromatik aminlar. Ularning tuzilishi, nomenklaturasi, olinishi, xossalari va ishlatilishi', 'Ароматические амины. Их строение, номенклатура, получение, свойства и применение', now(), now()),
            (126, 1, 125, 127, 123, 3, 'Aminokislotalar va ularning olinishi, xossalari', 'Аминокислоты и их получение, свойства', now(), now()),
            (127, 1, 126, 128, 123, 4, 'Oqsillarning tuzilishi va xossalari, biologik ahamiyati', 'Строение и свойства белков, биологическое значение', now(), now()),
            (128, 1, 127, 129, 123, 5, 'Tabiiy, sintetik va sun''iy yuqori molekular birikmalar', 'Природные, синтетические и искусственные высокомолекулярные соединения', now(), now()),
            (129, 1, 128, 130, 123, 6, 'Polimerlar, polimerlanish va polikondensatlanish reaksiyalari', 'Полимеры, реакции полимеризации и поликонденсации', now(), now()),
            (130, 1, 129, 131, 123, 7, 'Makromolekula, polimerlanish darajasi, polimerlarning olinishi va tuzilishi, kauchuk va tolalar', 'Макромолекула, степень полимеризации, получение и структура полимеров, каучуков и волокон', now(), now()),
            (131, 1, 130, 132, 123, 8, 'Eng muhim plastmassalarga umumiy tavsif. Eng muhim sintetik kauchuklar, ularning xossalari va ishlatilishi', 'Общее описание важнейших пластмасс. Важнейшие синтетические каучуки, их свойства и применение', now(), now());

-- 4-MODULE
insert into topics (id, subject_id, prev_id, next_id, seq, title_uz, title_ru, created_at, updated_at)
values (132, 1, 131, 133, 4, 'Amaliy mashg''ulot va laboratoriya tajribalari', 'Практические занятия и лабораторные эксперименты', now(), now());

insert into topics (id, subject_id, prev_id, next_id, parent_id, seq, title_uz, title_ru, created_at, updated_at)
values
        (133, 1, 132, 134, 132, 1, 'Kimyo xonasida jihozlar va reaktivlar bilan ishlashda xavfsizlik qoidalari', 'Правила безопасности при работе с оборудованием и реактивами в химическом кабинете', now(), now()),
        (134, 1, 133, 135, 132, 2, 'Kimyo laboratoriya jihozlarining turlari va ulardan foydalanish tartibi', 'Виды химического лабораторного оборудования и их применение', now(), now()),
        (135, 1, 134, 136, 132, 3, 'Geterogen aralashmalarni ajratish usullari (tindirish, filtrlash, bug''latish, magnit yordamida ajratish, distillash)', 'Методы разделения гетерогенных смесей (разделение, фильтрация, выпаривание, магнитная сепарация, перегонка)', now(), now()),
        (136, 1, 135, 137, 132, 4, 'Fizik xossalari turlicha bo''lgan moddalarni bir-biridan farqlash', 'Различать вещества с разными физическими свойствами', now(), now()),
        (137, 1, 136, 138, 132, 5, 'Laboratoriya sharoitida vodorod gazini olish, vodorodning mis (II) – oksid bilan o''zaro ta''siri', 'Получение газообразного водорода в лабораторных условиях, взаимодействие водорода с медью(II) - оксидом', now(), now()),
        (138, 1, 137, 139, 132, 6, 'Laboratoriya sharoitida turli konsentratsiyali eritmalarni tayyorlash', 'Приготовление растворов различной концентрации в лабораторных условиях', now(), now()),
        (139, 1, 138, 140, 132, 7, 'Galogenidlar, sulfat, karbonat, fosfat, ammoniy va galogen ionlari, turli metall kationlari uchun sifat reaksiyalari', 'Качественные реакции на галогениды, сульфат, карбонат, фосфат, ионы аммония и галогенов, катионы различных металлов', now(), now()),
        (140, 1, 139, 141, 132, 8, 'Asoslar va kislotalar, va boshqa kimyoviy moddalar eritmalarining indikatorlar rangini o''zgartirishi', 'Изменение цвета индикаторов растворов оснований и кислот и других химических веществ', now(), now()),
        (141, 1, 140, 142, 132, 9, 'Turli metall oksidlarining kislotalar bilan ta''sirlashuvi', 'Реакция оксидов различных металлов с кислотами', now(), now()),
        (142, 1, 141, 143, 132, 10, 'Reaksiyalarining borish shart-sharoitlari', 'Условия для реакций', now(), now()),
        (143, 1, 142, 144, 132, 11, 'Oksidlarning suv bilan o''zaro ta''sirlashuvidan olingan eritmalarda indikatorlar rangining o''zgarishi', 'Изменение цвета индикаторов в растворах, полученных при взаимодействии оксидов с водой', now(), now()),
        (144, 1, 143, 145, 132, 12, 'Suvda erimaydigan asoslarning kislotalar bilan o''zaro ta''siri', 'Взаимодействие нерастворимых в воде оснований с кислотами', now(), now()),
        (145, 1, 144, 146, 132, 13, 'Suvda erimaydigan asoslarning qizdirilganda parchalanishi', 'Разложение нерастворимых в воде оснований при нагревании', now(), now()),
        (146, 1, 145, 147, 132, 14, 'Metall gidroksidlarining olinishi, ularga kislota va ishqor eritmalarining ta''siri', 'Производство гидроксидов металлов, действие на них растворов кислот и щелочей', now(), now()),
        (147, 1, 146, 148, 132, 15, 'Kislotalarning metallar, asoslar, tuzlar bilan o''zaro ta''siri', 'Взаимодействие кислот с металлами, основаниями, солями', now(), now()),
        (148, 1, 147, 149, 132, 16, 'Tuz eritmalari bilan metallarning o''zaro ta''siri', 'Взаимодействие металлов с растворами солей', now(), now()),
        (149, 1, 148, 150, 132, 17, 'Al, Cu, Zn, Cr, Fe metallarining suvda eriydigan tuzlari va ular asosida boradigan tajribalar', 'Водорастворимые соли металлов Al, Cu, Zn, Cr, Fe и опыты на их основе', now(), now()),
        (150, 1, 149, 151, 132, 18, 'Laboratoriya sharoitida ammiak va karbonat angidrid olish va ularning kimyoviy xossalarini tekshirish', 'Получение аммиака и углекислого газа в лабораторных условиях и проверка их химических свойств', now(), now()),
        (151, 1, 150, 152, 132, 19, 'Laboratoriya sharoitida organik moddalarning olinishi va ularga xos sifat reaksiyalari', 'Получение органических веществ и характерные для них качественные реакции в лабораторных условиях', now(), now()),
        (152, 1, 151, 153, 132, 20, 'Organik moddalarni olinishi va ular uchun sifat reaksiyalari', 'Получение органических веществ и качественные реакции на них', now(), now()),
        (153, 1, 152, 154, 132, 21, 'Glitserin va glukoza uchun sifat reaksiya', 'Качественная реакция на глицерин и глюкозу', now(), now()),
        (154, 1, 153, 155, 132, 22, 'Oqsillarga xos rangli reaksiyalar', 'Цветовые реакции, специфичные для белков', now(), now());

-- 5-MODULE
insert into topics (id, subject_id, prev_id, next_id, seq, title_uz, title_ru, created_at, updated_at)
values (155, 1, 154, 156, 5, 'Reaksiyalar zanjiri asosida moddalarning o''zaro bir-biriga ta''sir o''tkazishi', 'Взаимодействие веществ на основе цепочки реакций', now(), now());

insert into topics (id, subject_id, prev_id, next_id, parent_id, seq, title_uz, title_ru, created_at, updated_at)
values
        (156, 1, 155, 157, 155, 1, 'Anorganik moddalarning eng muhim sinflari o''rtasida o''zaro genetik bog''lanish', 'Генетические взаимоотношения между важнейшими классами неорганических веществ', now(), now()),
        (157, 1, 156, 158, 155, 2, 'Organik moddalar o''rtasida boradigan kimyoviy jarayonlar', 'Химические процессы между органическими веществами', now(), now()),
        (158, 1, 157, 159, 155, 3, 'Noorganik va organik kimyodan olingan bilimlarni umumlashtirish', 'Обобщение знаний по неорганической и органической химии', now(), now()),
        (159, 1, 158, 160, 155, 4, 'Kimyoviy reaksiyalarning qonuniyatlari haqidagi bilimlarni umumlashtirish orqali kimyoviy ishlab chiqarishning umumiy ilmiy asoslari yuzasidan olingan bilimlarni sistemaga solish', 'Систематизация полученных знаний по общенаучным основам химического производства путем обобщения знаний о законах химических реакций', now(), now()),
        (160, 1, 159, null, 155, 5, 'O''zbekistonda kimyo fani va kimyo sanoatining rivojlanish istiqbollari', 'Перспективы развития химической науки и химической промышленности в Узбекистане', now(), now());

alter sequence topics_id_seq restart with 161;
----TOPIC

----TASK
--1
insert into tasks (id, subject_id, topic_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (1, 1, 1, false, '$^{107}Bh$ elementi tarkibida magnit kvant soni +3 bo''lgan nechta elektron mavjud?', 'Сколько электронов с магнитным квантовым числом +3 содержится в элементе $^{107}Bh$?', 'EASY', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (1, 1, '8', '8', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (2, 1, '14', '14', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (3, 1, '28', '28', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (4, 1, '4', '4', false, now(), now());

--2
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (2, 1, false, '500 ml 0,04M li sirka kislota eritmasiga 0,16 mol sof sirka kislota qo''shilganda kislotaning dissotsilanish darajasi necha foizdan bir foizgacha kamayadi?', 'Когда к 500 мл 0,04М раствора уксусной кислоты добавляют 0,16 моль чистой уксусной кислоты, на сколько процентов снижается степень диссоциации кислоты — от скольких процентов до скольких процентов?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (5, 2, '3', '3', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (6, 2, '4', '4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (7, 2, '5', '5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (8, 2, '2', '2', false, now(), now());

--3
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (3, 1, false, '16,8 g alken kaliy permanganat eritmasiga to''liq yuttirilishi natijasida kaliy permanganat eritmasining massasi 18 g ga kamaydi. Alkenning formulasini aniqlang.', 'При полном обесцвечивании 16,8 г алкена раствором перманганата калия масса раствора перманганата калия уменьшилась на 18 г. Определите формулу алкена.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (9, 3, '$C_3H_6$', '$C_3H_6$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (10, 3, '$C_2H_4$', '$C_2H_4$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (11, 3, '$C_5H_{10}$', '$C_5H_{10}$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (12, 3, '$C_4H_8$', '$C_4H_8$', false, now(), now());

--4
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (4, 1, false, 'Magniy sulfidi va fosfidi aralashmasida fosfor atomlari metall atomlaridan 2,5 molga kam, oltingugurt atomlaridan 3,5 molga ko''p bo''lsa, aralashma gidrolizidan necha litr (n.sh.) fosfin hosil bo''ladi?', 'В смеси сульфида и фосфида магния атомов фосфора на 2,5 моль меньше, чем атомов металла, и на 3,5 моль больше, чем атомов серы. Сколько литров фосфина выделится при гидролизе смеси (н.у.)?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (13, 4, '89,6', '89,6', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (14, 4, '67,2', '67,2', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (15, 4, '33,6', '33,6', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (16, 4, '44,8', '44,8', false, now(), now());

--5
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (5, 1, false, '15$^\circ$C dagi eruvchanligi 44 g bo''lgan tuzning to''yingan eritmasi 35$^\circ$C gacha isitilganda 80 g tuz erib, to''yingan eritma hosil qiladi. 15$^\circ$C dagi to''yingan eritmaning massasini (g) hisoblang. S(35$^\circ$C)=60', 'При растворимости соли 44 г при 15$^\circ$C, насыщенный раствор при нагревании до 35$^\circ$C может растворить в себе 80 г соли, образуя насыщенный раствор. Найдите массу насыщенного раствора при 15$^\circ$C. S(35$^\circ$C)=60', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (17, 5, '720', '720', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (18, 5, '725', '725', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (19, 5, '715', '715', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (20, 5, '710', '710', false, now(), now());

--6
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (6, 1, false, '$X_{(g)}$ + $2Y_{(g)}$ $\rightleftarrows$ $3Z_{(g)}$ sistemada reaksiya tezligi 0,6 mol/(l$\cdot$min). Agar tezlik konstantasi $k_1$ = 0,05 l$^2$/(mol$^2$ $\cdot$ min) va $X$ moddaning konsentratsiyasi 3M bo''lsa, $Y$ modda konsentratsiyasini (M) hisoblang', 'В системе: $X_{(г)}$ + $2Y_{(г)}$ $\rightleftarrows$ $3Z_{(г)}$ скорость прямой реакции составляет 0,6 моль/(л$\cdot$мин). Если константа скорости $k_1$ = 0,05 л$^2$/(моль$^2$ $\cdot$ мин), а концентрация вещества $X$ равна 3М, найдите концентрацию вещества $Y$ (М).', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (21, 6, '2', '2', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (22, 6, '4', '4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (23, 6, '3', '3', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (24, 6, '9', '9', false, now(), now());

--7
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (7, 1, false, 'Qaysi zarrachalar juftligida xlorning oksidlanish darajasi manfiy qiymatga ega?', 'В какой паре частиц степень окисления хлора имеет отрицательное значение?', 'EASY', 'THEORETICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (25, 7, 'ClBr$_3$ va ClF$_4$', 'ClBr$_3$ и ClF$_4$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (26, 7, 'PCl$_3$ va SCl$_2$', 'PCl$_3$ и SCl$_2$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (27, 7, 'ClO$^-_4$ va HCl', 'ClO$^-_4$ и HCl', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (28, 7, 'Cl$_2$O$_7$ va CCl$_4$', 'Cl$_2$O$_7$ и CCl$_4$', false, now(), now());

--8
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (8, 1, false, 'Etanol va sirka kislota aralashmasini to''liq neytrallash uchun 80 g 6,25%li $NaOH$ eritmasi sarflandi. Xuddi shunday massali aralashma o''zaro to''liq ta''sirlashib ($H^+$ ishtirokida) 8,8 g murakkab efir hosil qiladi. Dastlabki aralashma massasini (g) toping.', 'Для полного нейтрализования смеси этанола и уксусной кислоты израсходовано 80 г 6,25%-ного раствора NaOH. Такая же по массе смесь, прореагировав между собой (в присутствии $H^+$), образует 8,8 г сложного эфира. Найдите массу исходной смеси (г).', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (29, 8, '13,25', '13,25', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (30, 8, '12,1', '12,1', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (31, 8, '11,75', '11,75', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (32, 8, '10,6', '10,6', false, now(), now());

--9
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (9, 1, false, '$pH$=13 bo''lgan eritmada qaysi ion bo''lishi mumkin?<br>1) $K^+$; 2) $NH^+_4$; 3) $Sr^{2+}$; 4) $Cu^{2+}$', 'Какие ионы могут присутствовать в растворе с $pH$=13?<br>1) $K^+$; 2) $NH^+_4$; 3) $Sr^{2+}$; 4) $Cu^{2+}$', 'EASY', 'THEORETICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (33, 9, '1, 2, 3, 4', '1, 2, 3, 4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (34, 9, '1, 3, 4', '1, 3, 4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (35, 9, '1, 4', '1, 4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (36, 9, '1, 3', '1, 3', false, now(), now());

--10
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (10, 1, false, '30 g $FeO$ va $CuO$ dan iborat aralashma mo''l miqdordagi ammiak bilan qaytarildi. Olingan metallar 294 g 30%li $HNO_3$ kislota eritmasi bilan to''liq ta''sirlasha olsa, $FeO$ massasini (g) aniqlang. (Reaksiya natijasida $NO$ hosil bo''ladi.)', 'Смесь из 30 г $FeO$ и $CuO$ восстановили избытком аммиака. Полученные металлы полностью прореагировали с 294 г 30%-ной азотной кислоты. Определите массу $FeO$ (г) в исходной смеси. (В результате реакции образуется $NO$.)', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (37, 10, '27', '27', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (38, 10, '36', '36', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (39, 10, '18', '18', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (40, 10, '9', '9', false, now(), now());

--11
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (11, 1, false, '$X$ atomining radiusi - $R_1$, ionining radiusi esa - $R_2$. Bunga ko''ra quyidagi ifodalardan qaysilari to''g''ri?<br>1) $R_1$<$R_2$ bo''lsa, atom elektron olgan; 2) ion anion bo''lsa, $R_1$>$R_2$ bo''ladi; 3) atomdan elektron olish iondan elektron olish qiyinroq bo''lsa, $R_1$>$R_2$; 4) $R_1$>$R_2$ bo''lsa, atomning protonlari ionning protonlaridan kam.', 'Радиус атома $X$ - $R_1$, радиус иона - $R_2$. Какие из следующих утверждений верны?<br>1) Если $R_1 < R_2$, значит атом присоединил электрон; 2) Если ион — анион, то $R_1 > R_2$; 3) Если электрон труднее оторвать от атома, чем от иона, то $R_1 > R_2$; 4) Если $R_1 > R_2$, то у атома меньше протонов, чем у иона.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (41, 11, '1, 3', '1, 3', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (42, 11, '2, 4', '2, 4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (43, 11, '2, 3', '2, 3', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (44, 11, '1, 4', '1, 4', false, now(), now());

--12
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (12, 1, false, 'Xlor gazi ikkiga ajratildi va birinchi qismi sovuq, ikkinchi qismi qaynoq o''yuvchi natriy eritmasi bilan to''liq reaksiyaga kirishdi. Har ikkala reaksiya uchun bir xil miqdorda $NaOH$ sarflangan bo''lsa, xlorning qancha qismi birinchi reaksiya uchun sarflangan?', 'Хлорный газ был поделен на две части: первая часть полностью прореагировала с холодным раствором едкого натрия, вторая — с горячим. Если в обоих случаях было израсходовано одинаковое количество $NaOH$, то какая доля хлора пошла на первую реакцию?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (45, 12, '3/8', '3/8', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (46, 12, '5/8', '5/8', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (47, 12, '3/4', '3/4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (48, 12, '1/2', '1/2', false, now(), now());

--13
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (13, 1, false, '400 ml 1,5 molyarli kaliy gidrosulfit va 200 ml kaliy sulfit eritmalari aralashtirildi. Ushbu eritmaga 200 ml kaliy gidroksid eritmasi qo''shilganda, eritmadagi kaliy gidrosulfit konsentratsiyasi 0,5 mol/l gacha kamaydi. Eritmaga qo''shilgan kaliy gidroksid eritmasining konsentratsiyasini (mol/l) hisoblang.', 'Смешали 400 мл 1,5-молярного раствора калий гидросульфита и 200 мл раствора калий сульфита. После добавления 200 мл раствора калий гидроксида концентрация гидросульфита в растворе снизилась до 0,5 моль/л. Определите концентрацию раствора калий гидроксида, который был добавлен (моль/л).', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (49, 13, '0,6', '0,6', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (50, 13, '1,0', '1,0', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (51, 13, '0,4', '0,4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (52, 13, '0,8', '0,8', false, now(), now());

--14
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (14, 1, false, '11,4 g etan va siklopropan aralashmasining hajmi 6,72 l (n.sh.) bo''lsa, aralashmaga maksimal qancha (l, n.sh.) xlor birikishi mumkin?', 'Масса смеси этана и циклопропана составляет 11,4 г, а её объём при н.у. - 6,72 л. Какой максимальный объём хлора (л, при н.у.) может присоединиться к этой смеси?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (53, 14, '2,24', '2,24', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (54, 14, '1,12', '1,12', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (55, 14, '3,36', '3,36', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (56, 14, '4,48', '4,48', false, now(), now());

--15
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (15, 1, false, 'Gaz holidagi alkin va vodorod aralashmasi $(D(He)=2,4)$ $\textit{Ni}$ katalizatori ustidan o''tkazilganda bromli suvni rangsizlantirmaydigan gazlar arlashmasi $(D(He)=4)$ olindi. Alkinning molyar massasini (g/mol) hisoblang.', 'Смесь алкина и водорода в газообразном состоянии $(D(He)=2,4)$ пропустили над катализатором $\textit{Ni}$. В результате получена газовая смесь с плотностью по гелию $(D(He)=4)$, которая не обесцвечивает бромную воду. Определите молярную массу алкина (г/моль).', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (57, 15, '70', '70', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (58, 15, '54', '54', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (59, 15, '26', '26', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (60, 15, '40', '40', false, now(), now());

--16
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (16, 1, false, 'Nitrit kislotaning nisbiy molekular massasini hisoblang.', 'Вычислите относительную молекулярную массу нитритной кислоты.', 'EASY', 'THEORETICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (61, 16, '63', '63', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (62, 16, '82', '82', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (63, 16, '47', '47', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (64, 16, '98', '98', false, now(), now());

--17
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (17, 1, false, '$C_6H_{12}O_6$ + $KMnO_4$ + $H_2SO_4$ $\rightarrow$ $CO_2$ + $MnSO_4$ + $K_2SO_4$ + $H_2O$<br>Ushbu reaksiyadagi koeffitsiyentlar yig''indisini aniqlang.', '$C_6H_{12}O_6$ + $KMnO_4$ + $H_2SO_4$ $\rightarrow$ $CO_2$ + $MnSO_4$ + $K_2SO_4$ + $H_2O$<br>Определите сумму коэффициентов в этой реакции.', 'EASY', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (65, 17, '197', '197', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (66, 17, '185', '185', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (67, 17, '195', '195', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (68, 17, '180', '180', false, now(), now());

--18
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (18, 1, false, '48 g III valentli noma''lum metall oksidi $H_2$ va $CO$ aralashmasi yordamida qaytarildi. Reaksiya natijasida 5,4 g suv va 26,4 g $CO_2$ olingan bo''lsa, metallni toping.', '48 г оксида неизвестного III валентного металла восстановили смесью $H_2$ и $CO$. В результате реакции образовалось 5,4 г воды и 26,4 г $CO_2$. Определите металл.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (69, 18, '$Mn$', '$Mn$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (70, 18, '$Cr$', '$Cr$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (71, 18, '$Fe$', '$Fe$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (72, 18, '$Al$', '$Al$', false, now(), now());

--19
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (19, 1, false, '1 $\cdot$ 10$^{-4}$ mol polistirol 52 g bo''lsa, polimerlanish darajasini hisoblang.', 'Если 1 $\cdot$ 10$^{-4}$ моль полистирола имеет массу 52 г, вычислите степень полимеризации.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (73, 19, '4000', '4000', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (74, 19, '500', '500', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (75, 19, '5000', '5000', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (76, 19, '400', '400', false, now(), now());

--20
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (20, 1, false, 'Metall, kovalent va ion bog''lanishli moddalar ketma-ketligini toping.', 'Установите последовательность веществ с металлической, ковалентной и ионной связью.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (77, 20, '$Ag_2S$, $S_8$, KJ', '$Ag_2S$, $S_8$, KJ', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (78, 20, '$Ag$, $NO_2$, $SrF_2$', '$Ag$, $NO_2$, $SrF_2$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (79, 20, '$Zn$, $HF$, $NH_3$', '$Zn$, $HF$, $NH_3$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (80, 20, '$Pb$, $F_2$, $H_3AsO_4$', '$Pb$, $F_2$, $H_3AsO_4$', false, now(), now());

--21
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (21, 1, false, 'Chumoli va sirka kislotadan iborat 24,4 g aralashmani neytrallash uchun 250 g 8%li natriy gidroksid sarflangan bo''lsa, hosil bo''lgan organik mahsulotlar massalarini (g) aniqlang.', 'Смесь из муравьиной и уксусной кислот массой 24,4 г нейтрализовали 250 г 8%-ного раствора гидроксида натрия. Определите массы (г) образовавшихся органических продуктов.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (81, 21, '18,4; 6', '18,4; 6', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (82, 21, '13,6; 10,8', '13,6; 10,8', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (83, 21, '20,4; 16,4', '20,4; 16,4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (84, 21, '27,2; 8,2', '27,2; 8,2', false, now(), now());

--22
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (22, 1, false, '0,2 mol metoksimetan massasini (g) hisoblang.', 'Рассчитайте массу (г) 0,2 моль метоксиметана.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (85, 22, '9,2', '9,2', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (86, 22, '8,4', '8,4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (87, 22, '8,8', '8,8', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (88, 22, '9,6', '9,6', false, now(), now());

--23
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (23, 1, false, '$F^-$ ionidagi valent elektronlar sonini aniqlang.', 'Определите количество валентных электронов в ионе $F^-$.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (89, 23, '8', '8', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (90, 23, '9', '9', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (91, 23, '10', '10', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (92, 23, '7', '7', false, now(), now());

--24
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (24, 1, false, 'Quyidagi o''zgarishlar asosida fosfor tutgan $X$ va $Y$ moddalarnining molyar massalari (g/mol) yig''indisini toping.<br>$P$ $\xrightarrow{(O_2(mo''l)/t^\circ)}$ ... $\xrightarrow{(Ca(OH)_2, (mo''l))}$ ... $\xrightarrow{(SiO_2+C/t^\circ)}$ ... $\xrightarrow{HNO_3(kons)/t^\circ}$ $Y$', 'На основе следующих превращений найдите сумму молярных масс (г/моль) веществ $X$ и $Y$, содержащих фосфор.<br>$P$ $\xrightarrow{(O_2(избыт)/t^\circ)}$ ... $\xrightarrow{(Ca(OH)_2, (избыт.))}$ ... $\xrightarrow{(SiO_2+C/t^\circ)}$ ... $\xrightarrow{HNO_3(конц)/t^\circ}$ $Y$', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (93, 24, '452', '452', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (94, 24, '234', '234', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (95, 24, '341', '341', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (96, 24, '408', '408', false, now(), now());

--25
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (25, 1, false, 'Qaysi reagentlardan foydalanib bir bosqichda metanal olish mumkin?', 'Из каких реагентов можно получить метаналь в один этап?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (97, 25, '$CH_3OH$/$Cu$, t', '$CH_3OH$/$Cu$, t', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (98, 25, '$C_2H_2$/$H_2O$, $H^+$, $Hg^{2+}$', '$C_2H_2$/$H_2O$, $H^+$, $Hg^{2+}$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (99, 25, '$C_2H_5OH$/$CuO$, t', '$C_2H_5OH$/$CuO$, t', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (100, 25, '$CO$, $2H_2$/t, p', '$CO$, $2H_2$/t, p', false, now(), now());

--26
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (26, 1, false, 'Benzol + $Cl_{2(mo''l)}$ $\xrightarrow{\text{quyosh nuri}}$ ...<br>Reaksiya turi va olingan organik modda molekular massasini ko''rsating.', 'Бензол + $Cl_{2(избыт)}$ $\xrightarrow{\text{солнеч. луч}}$ ...<br>Укажите тип реакции и молекулярную массу полученного органического вещества.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (101, 26, 'almashinish; 112,5', 'замещение; 112,5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (102, 26, 'o''rin olish; 285', 'замещение; 285', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (103, 26, 'almashinish; 181,5', 'замещение; 181,5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (104, 26, 'birikish; 291', 'присоединение; 291', false, now(), now());

--27
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (27, 1, false, '250 g 19,5%li simob (II)-nitrat eritmasi elektroliz qilinganda, eritma massasi 50,55 g ga kamaydi. Elektroliz jarayonida ishtirok etgan suv massasini (g) hisoblang.', 'При электролизе 250 г 19,5%-ного раствора нитрата ртути (II) масса раствора уменьшилась на 50,55 г. Вычислите массу воды (г), участвовавшей в процессе электролиза.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (105, 27, '11,7', '11,7', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (106, 27, '19,8', '19,8', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (107, 27, '20,7', '20,7', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (108, 27, '12,6', '12,6', false, now(), now());

--28
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (28, 1, false, 'Etanol va to''yingan bir asosli aminokislotadan hosil bo''lgan 39,75 g murakkab efirning gidrolizi uchun 4,5 g suv sarflangan bo''lsa, aminokislota molyar massasini (g/mol) hisoblang.', 'Если для гидролиза 39,75 г сложного эфира, полученного из этанола и насыщенной одноосновной аминокислоты, израсходовано 4,5 г воды, вычислите молярную массу (г/моль) аминокислоты.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (109, 28, '117', '117', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (110, 28, '89', '89', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (111, 28, '131', '131', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (112, 28, '103', '103', false, now(), now());

--29
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (29, 1, false, '$XYO_3$ + 2$HCl$ $\rightarrow$ $XCl_2$ + $YO_2$ + $H_2O$<br>31,2 g $XYO_3$ reaksiyaga kirishganda 19,2 g $YO_2$ va 0,3$\cdot$$N_A$ ta $H_2O$ molekulasi hosil bo''ldi. Olingan tuzning massasini (g) hisoblang.', '$XYO_3$ + 2$HCl$ $\rightarrow$ $XCl_2$ + $YO_2$ + $H_2O$<br>При реакции 31,2 г $XYO_3$ образовалось 19,2 г $YO_2$ и 0,3$\cdot$$N_A$ молекул воды. Рассчитайте массу (г) полученной соли.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (113, 29, '40,5', '40,5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (114, 29, '33,3', '33,3', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (115, 29, '28,5', '28,5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (116, 29, '43,5', '43,5', false, now(), now());

--30
insert into tasks (id, subject_id, row_answers, content_uz, content_ru, level, type, created_at, updated_at)
values (30, 1, false, 'Molekulalarni tarkibidagi $\pi$- va $\sigma$-bog''lar yig''indisi ortib borishi tartibida joylashtiring.<br>1) oltingugurt (IV)-oksid; 2) metanal; 3) vodorod peroksid; 4) chumoli kislota; 5) gipoxlorit kislota.', 'Расположите молекулы в порядке увеличения суммы $\pi$- и $\sigma$-связей в их составе.<br>1) оксид серы (IV); 2) метаналь; 3) пероксид водорода; 4) муравьиная кислота; 5) хлорноватистая кислота.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (117, 30, '1, 4, 2, 3, 5', '1, 4, 2, 3, 5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (118, 30, '5, 3, 2, 4, 1', '5, 3, 2, 4, 1', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (119, 30, '1, 2, 3, 4, 5', '1, 2, 3, 4, 5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (120, 30, '5, 2, 4, 3, 1', '5, 2, 4, 3, 1', false, now(), now());

alter sequence tasks_id_seq restart with 31;
alter sequence answers_id_seq restart with 121;
----TASK