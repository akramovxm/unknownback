----TOPIC
-- 1-MODULE
insert into topics (id, next_id, seq, title, path, created_at, updated_at)
values (1, 2, 1, 'Umumiy kimyo', 'umumiy-kimyo', now(), now());

insert into topics (id, prev_id, next_id, parent_id, seq, title, path, created_at, updated_at)
values
        (2, 1, 3, 1, 1, 'Kimyoning asosiy tushunchalari', 'kimyoning-asosiy-tushunchalari', now(), now()),
            (3, 2, 4, 2, 1, 'Atom-molekular ta''limot. Kimyoviy element. Kimyoviy belgi', 'atom-molekular-talimot-kimyoviy-element-kimyoviy-belgi', now(), now()),
            (4, 3, 5, 2, 2, 'Atomlarning o''lchami. Nisbiy va absolut atom massa', 'atomlarning-olchami-nisbiy-va-absolut-atom-massa', now(), now()),
            (5, 4, 6, 2, 3, 'Molekular va nomolekular tuzilishdagi moddalar', 'molekular-va-nomolekular-tuzilishdagi-moddalar', now(), now()),
            (6, 5, 7, 2, 4, 'Oddiy va murakkab modda. Allotropiya', 'oddiy-va-murakkab-modda-allotropiya', now(), now()),
            (7, 6, 8, 2, 5, 'Moddalarning agregat holatlari', 'moddalarning-agregat-holatlari', now(), now()),
            (8, 7, 9, 2, 6, 'Kimyoviy formula va undan kelib chiqadigan xulosalar. Valentlik. Indeks', 'kimyoviy-formula-va-undan-kelib-chiqadigan-xulosalar-valentlik-indeks', now(), now()),
            (9, 8, 10, 2, 7, 'Sof modda va aralashma. Gomogen va geterogen aralashma', 'sof-modda-va-aralashma-gomogen-va-geterogen-aralashma', now(), now()),
            (10, 9, 11, 2, 8, 'Molekulalarning o''lchami, nisbiy va absolut massasi. Modda miqdori - mol. Molar massa. Avogadro doimiysi', 'molekulalarning-olchami-nisbiy-va-absolut-massasi-modda-miqdori-mol-molar-massa-avogadro-doimiysi', now(), now()),
            (11, 10, 12, 2, 9, 'Fizik va kimyoviy o''zgarishlar', 'fizik-va-kimyoviy-o''zgarishlar', now(), now()),
            (12, 11, 13, 2, 10, 'Kimyoviy reaksiyaning sodir bo''lishi. Kimyoviy reaksiyalar tenglamalari, koeffitsientlar', 'kimyoviy-reaksiyaning-sodir-bolishi-kimyoviy-reaksiyalar-tenglamalari-koeffitsientlar', now(), now()),

        (13, 12, 14, 1, 2, 'Kimyoning asosiy stexiometrik qonunlari', 'kimyoning-asosiy-stexiometrik-qonunlari', now(), now()),
            (14, 13, 15, 13, 1, 'Massaning saqlanish, tarkibning doimiylik, karrali nisbatlar va Avogadro qonunlari', 'massaning-saqlanish-tarkibning-doimiylik-karrali-nisbatlar-va-avogadro-qonunlari', now(), now()),
            (15, 14, 16, 13, 2, 'Molar hajm, gaz qonunlari, Mendeleyev-Klayperon tenglamasi', 'molar-hajm-gaz-qonunlari-mendeleyev-klayperon-tenglamasi', now(), now()),
            (16, 15, 17, 13, 3, 'Ekvivalent va ekvivalentlik qonuni, ekvivalent massa, ekvivalent miqdor', 'ekvivalent-va-ekvivalentlik-qonuni-ekvivalent-massa-ekvivalent-miqdor', now(), now()),
            (17, 16, 18, 13, 4, 'Gaz aralashmasi, gazlarning molar hajmi, gazning hajm ulushi, zichligi va nisbiy zichligi', 'gaz-aralashmasi-gazlarning-molar-hajmi-gazning-hajm-ulushi-zichligi-va-nisbiy-zichligi', now(), now()),
            (18, 17, 19, 13, 5, 'Kimyoviy reaksiya turlari. Birikish, parchalanish, o''rin olish, almashinish reaksiyalari', 'kimyoviy-reaksiya-turlari-birikish-parchalanish-orin-olish-almashinish-reaksiyalari', now(), now()),
            (19, 18, 20, 13, 6, 'Reaksiyaning issiqlik miqdori, ekzotermik, endotermik reaksiyalar', 'reaksiyaning-issiqlik-miqdori-ekzotermik-endotermik-reaksiyalar', now(), now()),
            (20, 19, 21, 13, 7, 'Murakkab moddalar tarkibidagi elementlarning massa ulushlarini hisoblash', 'murakkab-moddalar-tarkibidagi-elementlarning-massa-ulushlarini-hisoblash', now(), now()),
            (21, 20, 22, 13, 8, 'Modda tarkibidagi elementlarning miqdoriy nisbatlari aniq bo''lganda modda formulasini topish', 'modda-tarkibidagi-elementlarning-miqdoriy-nisbatlari-aniq-bolganda-modda-formulasini-topish', now(), now()),
            (22, 21, 23, 13, 9, 'Kimyoviy reaksiyalar asosida hisoblashlar, reaksiya unumi', 'kimyoviy-reaksiyalar-asosida-hisoblashlar-reaksiya-unumi', now(), now()),

        (23, 22, 24, 1, 3,  'Davriy qonun va davriy sistema. Atom tuzilishi', 'davriy-qonun-va-davriy-sistema-atom-tuzilishi', now(), now()),
            (24, 23, 25, 23, 1, 'Davriy qonun va davriy sistema', 'davriy-qonun-va-davriy-sistema', now(), now()),
            (25, 24, 26, 23, 2, 'Atom tuzilishi, atom yadrosi tarkibi, izotop, izoton, izobar va izoelektronlar', 'atom-tuzilishi-atom-yadrosi-tarkibi-izotop-izoton-izobar-va-izoelektronlar', now(), now()),
            (26, 25, 27, 23, 3, 'Atom elektron qavatlarining tuzilishi, energetik pog''onalar, energetik pog''onachalar, elektron konfiguratsiya', 'atom-elektron-qavatlarining-tuzilishi-energetik-pogonalar-energetik-pogonachalar-elektron-konfiguratsiya', now(), now()),
            (27, 26, 28, 23, 4, 'Kvant sonlar, Klechkovskiy qoidasi, Pauli prinsipi, Gund qoidasi', 'kvant-sonlar-klechkovskiy-qoidasi-pauli-prinsipi-gund-qoidasi', now(), now()),
            (28, 27, 29, 23, 5, 'Yadro reaksiyalari, alfa, betta, gamma - nurlanishlar. Davr va guruhlarda elementlar xossalarining o''zgarishi, davriy xossalar', 'yadro-reaksiyalari-alfa-betta-gamma-nurlanishlar-davr-va-guruhlarda-elementlar-xossalarining-ozgarishi-davriy-xossalar', now(), now()),

        (29, 28, 30, 1, 4, 'Kimyoviy bog''lanish turlari. Kristall panjaralar', 'kimyoviy-boglanish-turlari-kristall-panjaralar', now(), now()),
            (30, 29, 31, 29, 1, 'Kimyoviy bog''lanishlar. Bog'' xossasi', 'kimyoviy-boglanishlar-bog-xossasi', now(), now()),
            (31, 30, 32, 29, 2, 'Kimyoviy bog''lanishlar energiyasi, bog''lanish uzunligi, valent burchak, bog''lanish tartibi', 'kimyoviy-boglanishlar-energiyasi-boglanish-uzunligi-valent-burchak-boglanish-tartibi', now(), now()),
            (32, 31, 33, 29, 3, 'Molekulalarning o''lchami, nisbiy va absolut massasi', 'molekulalarning-olchami-nisbiy-va-absolut-massasi', now(), now()),
            (33, 32, 34, 29, 4, 'Bog''lanish turlari: kovalent (qutbli va qutbsiz, donor - akseptor), metall, ionli, vodorod', 'boglanish-turlari-kovalent-(qutbli-va-qutbsiz-donor-akseptor)-metall-ionli-vodorod', now(), now()),
            (34, 33, 35, 29, 5, 'Kristall panjara turlari, kristall va amorf moddalar, tuzilish formulalari, sigma va pi bog''lanishlar', 'kristall-panjara-turlari-kristall-va-amorf-moddalar-tuzilish-formulalari-sigma-va-pi-boglanishlar', now(), now()),

        (35, 34, 36, 1, 5, 'Kimyoviy reaksiyalarning kinetikasi. Kimyoviy muvozanat', 'kimyoviy-reaksiyalarning-kinetikasi-kimyoviy-muvozanat', now(), now()),
            (36, 35, 37, 35, 1, 'Reaksiya tezligi va unga ta''sir etuvchi omillar (modda tabiati, gaz va suyuq moddalar konsentratsiyasi, bosim, hajm, harorat)', 'reaksiya-tezligi-va-unga-tasir-etuvchi-omillar-(modda-tabiati-gaz-va-suyuq-moddalar-konsentratsiyasi-bosim-hajm-harorat)', now(), now()),
            (37, 36, 38, 35, 2, 'Kataliz va katalizator. Fermentlar, ingibitor haqida tushuncha', 'kataliz-va-katalizator-fermentlar-ingibitor-haqida-tushuncha', now(), now()),
            (38, 37, 39, 35, 3, 'Qaytar va qaytmas reaksiyalar, to''g''ri va teskari reaksiyalar', 'qaytar-va-qaytmas-reaksiyalar-togri-va-teskari-reaksiyalar', now(), now()),
            (39, 38, 40, 35, 4, 'Kimyoviy muvozanat va uning siljishi. Le-Shatelye prinsipi', 'kimyoviy-muvozanat-va-uning-siljishi-le-shatelye-prinsipi', now(), now()),
            (40, 39, 41, 35, 5, 'Kimyoviy muvozanatga bosimning, konsentratsiyaning va haroratning ta''siri', 'kimyoviy-muvozanatga-bosimning-konsentratsiyaning-va-haroratning-tasiri', now(), now()),

        (41, 40, 42, 1, 6, 'Eritmalar', 'eritmalar', now(), now()),
            (42, 41, 43, 41, 1, 'Eritmaning aralashma va kimyoviy birikma bilan o''xshashligi va farqi', 'eritmaning-aralashma-va-kimyoviy-birikma-bilan-oxshashligi-va-farqi', now(), now()),
            (43, 42, 44, 41, 2, 'Eritma tarkibidagi erigan modda miqdoriga ko''ra eritmalarning turlari', 'eritma-tarkibidagi-erigan-modda-miqdoriga-kora-eritmalarning-turlari', now(), now()),
            (44, 43, 45, 41, 3, 'Eritmalar konsentratsiyalarini ifodalash usullari (massa ulush, foiz konsentratsiya, molar va normal konsentratsiyalar)', 'eritmalar-konsentratsiyalarini-ifodalash-usullari-(massa-ulush-foiz-konsentratsiya-molar-va-normal-konsentratsiyalar)', now(), now()),
            (45, 44, 46, 41, 4, 'Foiz va molar, foiz va normal konsentratsiya o''rtasidagi bog''lanish', 'foiz-va-molar-foiz-va-normal-konsentratsiya-ortasidagi-boglanish', now(), now()),
            (46, 45, 47, 41, 5, 'Eruvchanlik koeffitsiyenti', 'eruvchanlik-koeffitsiyenti', now(), now()),
            (47, 46, 48, 41, 6, 'To''yingan, to''yinmagan, o''ta to''yingan eritmalar', 'toyingan-toyinmagan-ota-toyingan-eritmalar', now(), now()),
            (48, 47, 49, 41, 7, 'Kristallogidratlar', 'kristallogidratlar', now(), now()),
            (49, 48, 50, 41, 8, 'Kimyoviy moddalarning amaliy ahamiyati', 'kimyoviy-moddalarning-amaliy-ahamiyati', now(), now()),

        (50, 49, 51, 1, 7, 'Elektrolitik dissotsiatsiyalanish nazariyasi', 'elektrolitik-dissotsiatsiyalanish-nazariyasi', now(), now()),
            (51, 50, 52, 50, 1, 'Elektrolitik dissotsiatsiyalanish nazariyasi. Elektrolitlar va noelektrolitlar', 'elektrolitik-dissotsiatsiyalanish-nazariyasi-elektrolitlar-va-noelektrolitlar', now(), now()),
            (52, 51, 53, 50, 2, 'Kislota, ishqor va tuzlarning dissotsiatsiyalanishi', 'kislota-ishqor-va-tuzlarning-dissotsiatsiyalanishi', now(), now()),
            (53, 52, 54, 50, 3, 'Elektrolitlarning dissotsiatsiyalanish darajasi', 'elektrolitlarning-dissotsiatsiyalanish-darajasi', now(), now()),
            (54, 53, 55, 50, 4, 'Ionlar: kation va anionlar', 'ionlar-kation-va-anionlar', now(), now()),
            (55, 54, 56, 50, 5, 'Kuchli va kuchsiz elektrolitlar', 'kuchli-va-kuchsiz-elektrolitlar', now(), now()),
            (56, 55, 57, 50, 6, 'Dissotsiatsiyalanish konstantasi, ion almashinish reaksiyalari, qisqa va to''liq ionli tenglamalar', 'dissotsiatsiyalanish-konstantasi-ion-almashinish-reaksiyalari-qisqa-va-toliq-ionli-tenglamalar', now(), now()),
            (57, 56, 58, 50, 7, 'Suvning ion ko''paytmasi, pH va pOH', 'suvning-ion-kopaytmasi-pH-va-pOH', now(), now()),
            (58, 57, 59, 50, 8, 'Tuzlar gidrolizi, tuzlar gidrolizlanganda sodir bo''ladigan jarayonlar va undagi eritma muhiti', 'tuzlar-gidrolizi-tuzlar-gidrolizlanganda-sodir-boladigan-jarayonlar-va-undagi-eritma-muhiti', now(), now()),

        (59, 58, 60, 1, 8, 'Oksidlanish-qaytarilish reaksiyalari', 'oksidlanish-qaytarilish-reaksiyalari', now(), now()),
            (60, 59, 61, 59, 1, 'Oksidlanish darajasi', 'oksidlanish-darajasi', now(), now()),
            (61, 60, 62, 59, 2, 'Oksidlanish-qaytarilish reaksiyalari (oksidlanish hamda qaytarilish jarayonlari, oksidlovchi va qaytaruvchilar)', 'oksidlanish-qaytarilish-reaksiyalari-(oksidlanish-hamda-qaytarilish-jarayonlari-oksidlovchi-va-qaytaruvchilar)', now(), now()),
            (62, 61, 63, 59, 3, 'Oksidlanish-qaytarilish reaksiyalarini tenglash usullari – elektron balans va yarim reaksiya usuli', 'oksidlanish-qaytarilish-reaksiyalarini-tenglash-usullari–elektron-balans-va-yarim-reaksiya-usuli', now(), now()),

        (63, 62, 64, 1, 9, 'Elektroliz', 'elektroliz', now(), now()),
            (64, 63, 65, 63, 1, 'Elektroliz va unda sodir bo''ladigan jarayonlar', 'elektroliz-va-unda-sodir-boladigan-jarayonlar', now(), now()),
            (65, 64, 66, 63, 2, 'Katod va anod, inert elektrodlar, eruvchan va erimaydigan anodlar', 'katod-va-anod-inert-elektrodlar-eruvchan-va-erimaydigan-anodlar', now(), now()),
            (66, 65, 67, 63, 3, 'Faradey soni. Eritma va suyuqlanma elektrolizi', 'faradey-soni-eritma-va-suyuqlanma-elektrolizi', now(), now()),
            (67, 66, 68, 63, 4, 'Katodda sodir bo''ladigan qaytarilish jarayoni, anodda sodir bo''ladigan oksidlanish jarayoni', 'katodda-sodir-boladigan-qaytarilish-jarayoni-anodda-sodir-boladigan-oksidlanish-jarayoni', now(), now()),
            (68, 67, 69, 63, 5, 'Metallarning aktivlik qatori. Elektrolizga doir Faradey qonunlari', 'metallarning-aktivlik-qatori-elektrolizga-doir-faradey-qonunlari', now(), now());

-- 2-MODULE
insert into topics (id, prev_id, next_id, seq, title, path, created_at, updated_at)
values (69, 68, 70, 2, 'Anorganik kimyo', 'anorganik-kimyo', now(), now());

insert into topics (id, prev_id, next_id, parent_id, seq, title, path, created_at, updated_at)
values
        (70, 69, 71, 69, 1, 'Anorganik moddalarning eng muhim sinflari', 'anorganik-moddalarning-eng-muhim-sinflari', now(), now()),
            (71, 70, 72, 70, 1, 'Oksidlarning tarkibi, tuzilishi, nomlanishi va ularning turlari; olinish usullari va xossalari', 'oksidlarning-tarkibi-tuzilishi-nomlanishi-va-ularning-turlari-olinish-usullari-va-xossalari', now(), now()),
            (72, 71, 73, 70, 2, 'Asoslarning tarkibi, tuzilishi, nomlanishi va ularning turlari; olinish usullari va xossalari', 'asoslarning-tarkibi-tuzilishi-nomlanishi-va-ularning-turlari-olinish-usullari-va-xossalari', now(), now()),
            (73, 72, 74, 70, 3, 'Kislotalarning tarkibi, tuzilishi, nomlanishi va turlari; olinish usullari va xossalari', 'kislotalarning-tarkibi-tuzilishi-nomlanishi-va-ularning-turlari-olinish-usullari-va-xossalari', now(), now()),
            (74, 73, 75, 70, 4, 'Tuzlarning tarkibi, tuzilishi, nomlanishi va ularning turlari; olinish usullari va xossalari', 'tuzlarning-tarkibi-tuzilishi-nomlanishi-va-ularning-turlari-olinish-usullari-va-xossalari', now(), now()),
            (75, 74, 76, 70, 5, 'Eng muhim oksidlar, asoslar, kislotalar va tuzlarning ishlatilishi', 'eng-muhim-oksidlar-asoslar-kislotalar-va-tuzlarning-ishlatilishi', now(), now()),
            (76, 75, 77, 70, 6, 'Anorganik moddalarning eng muhim sinflari o''rtasidagi genetik bog''lanish', 'anorganik-moddalarning-eng-muhim-sinflari-ortasidagi-genetik-boglanish', now(), now()),

        (77, 76, 78, 69, 2, 'Metallmaslar', 'metallmaslar', now(), now()),
            (78, 77, 79, 77, 1, 'Metallmaslarning davriy sistemada joylashishi, tabiatda tarqalishi, metallmaslarning tabiiy oilalari, olinish usullari va ishlatilishi', 'metallmaslarning-davriy-sistemada-joylashishi-tabiatda tarqalishi-metallmaslarning-tabiiy-oilalari-olinish-usullari-va-ishlatilishi', now(), now()),
            (79, 78, 80, 77, 2, 'Metallmaslarning fizik va kimyoviy xossalari, ularning birikmalari', 'metallmaslarning-fizik-va-kimyoviy-xossalari-ularning-birikmalari', now(), now()),
            (80, 79, 81, 77, 3, 'Kislorod va uning izotoplari, allotropiyasi, olinish usullari va xossalari', 'kislorod-va-uning-izotoplari-allotropiyasi-olinish-usullari-va-xossalari', now(), now()),
            (81, 80, 82, 77, 4, 'Vodorod va uning izotoplari, olinish usullari va xossalari', 'vodorod-va-uning-izotoplari-olinish-usullari-va-xossalari', now(), now()),
            (82, 81, 83, 77, 5, 'Uglerod va uning eng muhim birikmalari, uglerod guruhchasi metallmaslari', 'uglerod-va-uning-eng-muhim-birikmalari-uglerod-guruhchasi-metallmaslari', now(), now()),
            (83, 82, 84, 77, 6, 'Azot va uning birikmalari, nitrat kislotani olinish usullari hamda xossalari, nitratlar, azot guruhchasi metallmaslari', 'azot-va-uning-birikmalari-nitrat-kislotani-olinish-usullari-hamda-xossalari-nitratlar-azot-guruhchasi-metallmaslari', now(), now()),
            (84, 83, 85, 77, 7, 'Xalkogenlar, oltingugurt va oltingugurt birikmalarining xossalari, sulfat kislotaning olinish usullari hamda xossalari, oleum. Sulfat va nitrat kislotalarni sanoatda ishlab chiqarish', 'xalkogenlar-oltingugurt-va-oltingugurt-birikmalarining-xossalari-sulfat-kislotaning-olinish-usullari-hamda-xossalari-oleum-sulfat-va-nitrat-kislotalarni-sanoatda-ishlab-chiqarish', now(), now()),
            (85, 84, 86, 77, 8, 'Galogenlar va nodir gazlar, ularning tabiatda tarqalishi, olinish usullari hamda xossalari', 'galogenlar-va-nodir-gazlar-ularning-tabiatda-tarqalishi-olinish-usullari-hamda-xossalari', now(), now()),
            (86, 85, 87, 77, 9, 'Mineral o''g''itlar. Makro va mikroelementlar, oddiy va kompleks o''g''itlar. Azotli, fosforli va kaliyli o''g''itlar, ularda ozuqa elementining miqdorini hisoblash. Biogen elementlar va ularning tirik organizmlardagi ahamiyati', 'mineral-ogitlar-makro-va-mikroelementlar-oddiy-va-kompleks-ogitlar-azotli-fosforli-va-kaliyli-ogitlar-ularda-ozuqa-elementining-miqdorini-hisoblash-biogen-elementlar-va-ularning-tirik-organizmlardagi-ahamiyati', now(), now()),

        (87, 86, 88, 69, 3, 'Metallar', 'metallar', now(), now()),
            (88, 87, 89, 87, 1, 'Metallarning davriy jadvaldagi o''rni, tabiatda tarqalishi, olinish usullari va ishlatilshi', 'metallarning-davriy-jadvaldagi-orni-tabiatda-tarqalishi-olinish-usullari-va-ishlatilshi', now(), now()),
            (89, 88, 90, 87, 2, 'Metallarning fizik va kimyoviy xossalari, ularning birikmalari', 'metallarning-fizik-va-kimyoviy-xossalari-ularning-birikmalari', now(), now()),
            (90, 89, 91, 87, 3, 'Ishqoriy va ishqoriy-yer metallar. Ularning olinish usullari, xossalari, birikmalari va ishlatilishi', 'ishqoriy-va-ishqoriy-yer-metallar-ularning-olinish-usullari-xossalari-birikmalari-va-ishlatilishi', now(), now()),
            (91, 90, 92, 87, 4, 'Suvning qattiqligi va uni yo''qotish usullari', 'suvning-qattiqligi-va-uni-yoqotish-usullari', now(), now()),
            (92, 91, 93, 87, 5, 'Aluminiy', 'aluminiy', now(), now()),
            (93, 92, 94, 87, 6, 'I guruhning yonaki guruhchasi (Cu, Ag, Au)', 'I-guruhning-yonaki-guruhchasi-(Cu-Ag-Au)', now(), now()),
            (94, 93, 95, 87, 7, 'II guruhning yonaki guruhchasi elementlari (Zn, Cd, Hg)', 'II-guruhning-yonaki-guruhchasi-elementlari-(Zn-Cd-Hg)', now(), now()),
            (95, 94, 96, 87, 8, 'Xrom, marganes, temir metallarining xossalari, ularning eng asosiy birikmalarining olinishi, xossalari, ishlatilishi', 'xrom-marganes-temir-metallarining-xossalari-ularning-eng-asosiy-birikmalarining-olinishi-xossalari-ishlatilishi', now(), now()),
            (96, 95, 97, 87, 9, 'Metallar korroziyasi va ularni korroziyadan himoyalash usullari', 'metallar-korroziyasi-va-ularni-korroziyadan-himoyalash-usullari', now(), now()),
            (97, 96, 98, 87, 10, 'Qotishmalar. Cho''yan va po''lat ishlab chiqarish', 'qotishmalar-choyan-va-polat-ishlab-chiqarish', now(), now()),
            (98, 97, 99, 87, 11, 'Kompleks birikmalar', 'kompleks-birikmalar', now(), now());

-- 3-MODULE
insert into topics (id, prev_id, next_id, seq, title, path, created_at, updated_at)
values (99, 98, 100, 3, 'Organik kimyo', 'organik-kimyo', now(), now());

insert into topics (id, prev_id, next_id, parent_id, seq, title, path, created_at, updated_at)
values
        (100, 99, 101, 99, 1, 'Organik kimyoning asosiy tushuncha va qonunlari. To''yingan uglevodorodlar', 'organik-kimyoning-asosiy-tushuncha-va-qonunlari-toyingan-uglevodorodlar', now(), now()),
            (101, 100, 102, 100, 1, 'Organik kimyoning asosiy tushuncha va qonunlari. Organik birikmalarning o''ziga xos xususiyatlari', 'organik-kimyoning-asosiy-tushuncha-va-qonunlari-organik-birikmalarning-oziga-xos-xususiyatlari', now(), now()),
            (102, 101, 103, 100, 2, 'A.M.Butlerovning organik birikmalarning kimyoviy tuzilish nazariyasi', 'a.m.butlerovning-organik-birikmalarning-kimyoviy-tuzilish-nazariyasi', now(), now()),
            (103, 102, 104, 100, 3, 'Organik birikmalarning sinflanishi', 'organik-birikmalarning-sinflanishi', now(), now()),
            (104, 103, 105, 100, 4, 'Organik birikmalarga xos reaksiya turlari, izomeriya va uning turlari', 'organik-birikmalarga-xos-reaksiya-turlari-izomeriya-va-uning-turlari', now(), now()),
            (105, 104, 106, 100, 5, 'To''yingan uglevodorodlar', 'toyingan-uglevodorodlar', now(), now()),
            (106, 105, 107, 100, 6, 'Alkanlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'alkanlar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (107, 106, 108, 100, 7, 'Sikloalkanlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'sikloalkanlar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),

        (108, 107, 109, 99, 2, 'To''yinmagan uglevodorodlar', 'toyinmagan-uglevodorodlar', now(), now()),
            (109, 108, 110, 108, 1, 'Alkenlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'alkenlar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (110, 109, 111, 108, 2, 'Alkadiyenlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'alkadiyenlar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (111, 110, 112, 108, 3, 'Alkinlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'alkinlar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (112, 111, 113, 108, 4, 'Aromatik uglevodorodlarning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'aromatik-uglevodorodlarning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (113, 112, 114, 108, 5, 'Organik birikmalarda uglerod atomining gibridlanishi', 'organik-birikmalarda-uglerod-atomining-gibridlanishi', now(), now()),
            (114, 113, 115, 108, 6, 'Uglevodorodlarning tabiiy manbalari. Neft, tabiiy gaz va toshko''mir', 'uglevodorodlarning-tabiiy-manbalari-neft-tabiiy-gaz-va-toshkomir', now(), now()),

        (115, 114, 116, 99, 3, 'Kislorodli organik birikmalar', 'kislorodli-organik-birikmalar', now(), now()),
            (116, 115, 117, 115, 1, 'To''yingan bir atomli va ko''p atomli spirtlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'toyingan-bir-atomli-va-kop-atomli-spirtlar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (117, 116, 118, 115, 2, 'Fenollar va aromatik spirtlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'fenollar-va-aromatik-spirtlar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (118, 117, 119, 115, 3, 'Aldegidlar va ketonlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'aldegidlar-va-ketonlar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),

        (119, 118, 120, 99, 4, 'Karbon kislotalar, efirlar va uglevodlar', 'karbon-kislotalar-efirlar-va-uglevodlar', now(), now()),
            (120, 119, 121, 119, 1, 'Karbon kislotalar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, tabiatda tarqalishi, olinish usullari, xossalari hamda ishlatilishi', 'karbon-kislotalar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-tabiatda-tarqalishi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (121, 120, 122, 119, 2, 'Oddiy va murakkab efirlar. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, tabiatda tarqalishi, olinish usullari, xossalari hamda ishlatilishi', 'oddiy-va-murakkab-efirlar-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-tabiatda-tarqalishi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (122, 121, 123, 119, 3, 'Yog''lar, sovun va yuvish vositalari. Ularning tuzilishi, gomologik qatori, izomeriyasi, nomenklaturasi, tabiatda tarqalishi, olinish usullari, xossalari hamda ishlatilishi', 'yoglar-sovun-va-yuvish-vositalari-ularning-tuzilishi-gomologik-qatori-izomeriyasi-nomenklaturasi-tabiatda-tarqalishi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),
            (123, 122, 124, 119, 4, 'Uglevodlar. Monosaxaridlar, disaxaridlar, polisaxaridlarning tuzilishi, izomeriyasi, nomenklaturasi, olinish usullari, xossalari hamda ishlatilishi', 'uglevodlar-monosaxaridlar-disaxaridlar-polisaxaridlarning-tuzilishi-izomeriyasi-nomenklaturasi-olinish-usullari-xossalari-hamda-ishlatilishi', now(), now()),

        (124, 123, 125, 99, 5, 'Azotli organik birikmalar. Yuqori molekulyar birikmalar', 'azotli-organik-birikmalar-yuqori-molekulyar-birikmalar', now(), now()),
            (125, 124, 126, 124, 1, 'Nitrobirikmalar va aminlar. Ularning tuzilishi, nomenklaturasi, olinishi, xossalari va ishlatilishi', 'nitrobirikmalar-va-aminlar-ularning-tuzilishi-nomenklaturasi-olinishi-xossalari-va-ishlatilishi', now(), now()),
            (126, 125, 127, 124, 2, 'Aromatik aminlar. Ularning tuzilishi, nomenklaturasi, olinishi, xossalari va ishlatilishi', 'aromatik-aminlar-ularning-tuzilishi-nomenklaturasi-olinishi-xossalari-va-ishlatilishi', now(), now()),
            (127, 126, 128, 124, 3, 'Aminokislotalar va ularning olinishi, xossalari', 'aminokislotalar-va-ularning-olinishi-xossalari', now(), now()),
            (128, 127, 129, 124, 4, 'Oqsillarning tuzilishi va xossalari, biologik ahamiyati', 'oqsillarning-tuzilishi-va-xossalari-biologik-ahamiyati', now(), now()),
            (129, 128, 130, 124, 5, 'Tabiiy, sintetik va sun''iy yuqori molekular birikmalar', 'tabiiy-sintetik-va-suniy-yuqori-molekular-birikmalar', now(), now()),
            (130, 129, 131, 124, 6, 'Polimerlar, polimerlanish va polikondensatlanish reaksiyalari', 'polimerlar-polimerlanish-va-polikondensatlanish-reaksiyalari', now(), now()),
            (131, 130, 132, 124, 7, 'Makromolekula, polimerlanish darajasi, polimerlarning olinishi va tuzilishi, kauchuk va tolalar', 'makromolekula-polimerlanish-darajasi-polimerlarning-olinishi-va-tuzilishi-kauchuk-va-tolalar', now(), now()),
            (132, 131, 133, 124, 8, 'Eng muhim plastmassalarga umumiy tavsif. Eng muhim sintetik kauchuklar, ularning xossalari va ishlatilishi', 'eng-muhim-plastmassalarga-umumiy-tavsif-eng-muhim-sintetik-kauchuklar-ularning-xossalari-va-ishlatilishi', now(), now());

-- 4-MODULE
insert into topics (id, prev_id, next_id, seq, title, path, created_at, updated_at)
values (133, 132, 134, 4, 'Amaliy mashg''ulot va laboratoriya tajribalari', 'amaliy-mashgulot-va-laboratoriya-tajribalari', now(), now());

insert into topics (id, prev_id, next_id, parent_id, seq, title, path, created_at, updated_at)
values
        (134, 133, 135, 133, 1, 'Kimyo xonasida jihozlar va reaktivlar bilan ishlashda xavfsizlik qoidalari', 'kimyo-xonasida-jihozlar-va-reaktivlar-bilan-ishlashda-xavfsizlik-qoidalari', now(), now()),
        (135, 134, 136, 133, 2, 'Kimyo laboratoriya jihozlarining turlari va ulardan foydalanish tartibi', 'kimyo-laboratoriya-jihozlarining-turlari-va-ulardan-foydalanish-tartibi', now(), now()),
        (136, 135, 137, 133, 3, 'Geterogen aralashmalarni ajratish usullari (tindirish, filtrlash, bug''latish, magnit yordamida ajratish, distillash)', 'geterogen-aralashmalarni-ajratish-usullari-(tindirish-filtrlash-buglatish-magnit-yordamida-ajratish-distillash)', now(), now()),
        (137, 136, 138, 133, 4, 'Fizik xossalari turlicha bo''lgan moddalarni bir-biridan farqlash', 'fizik-xossalari-turlicha-bolgan-moddalarni-bir-biridan-farqlash', now(), now()),
        (138, 137, 139, 133, 5, 'Laboratoriya sharoitida vodorod gazini olish, vodorodning mis (II) – oksid bilan o''zaro ta''siri', 'laboratoriya-sharoitida-vodorod-gazini-olish,-vodorodning-mis-(II)–oksid-bilan-ozaro-tasiri', now(), now()),
        (139, 138, 140, 133, 6, 'Laboratoriya sharoitida turli konsentratsiyali eritmalarni tayyorlash', 'laboratoriya-sharoitida-turli-konsentratsiyali-eritmalarni-tayyorlash', now(), now()),
        (140, 139, 141, 133, 7, 'Galogenidlar, sulfat, karbonat, fosfat, ammoniy va galogen ionlari, turli metall kationlari uchun sifat reaksiyalari', 'galogenidlar-sulfat-karbonat-fosfat-ammoniy-va-galogen-ionlari-turli-metall-kationlari--uchun-sifat-reaksiyalari', now(), now()),
        (141, 140, 142, 133, 8, 'Asoslar va kislotalar, va boshqa kimyoviy moddalar eritmalarining indikatorlar rangini o''zgartirishi', 'asoslar-va-kislotalar-va-boshqa-kimyoviy-moddalar-eritmalarining-indikatorlar-rangini-ozgartirishi', now(), now()),
        (142, 141, 143, 133, 9, 'Turli metall oksidlarining kislotalar bilan ta''sirlashuvi', 'turli-metall-oksidlarining-kislotalar-bilan-tasirlashuvi', now(), now()),
        (143, 142, 144, 133, 10, 'Reaksiyalarining borish shart-sharoitlari', 'reaksiyalarining-borish-shart-sharoitlari', now(), now()),
        (144, 143, 145, 133, 11, 'Oksidlarning suv bilan o''zaro ta''sirlashuvidan olingan eritmalarda indikatorlar rangining o''zgarishi', 'oksidlarning-suv-bilan-ozaro-tasirlashuvidan-olingan-eritmalarda-indikatorlar-rangining-ozgarishi', now(), now()),
        (145, 144, 146, 133, 12, 'Suvda erimaydigan asoslarning kislotalar bilan o''zaro ta''siri', 'suvda-erimaydigan-asoslarning-kislotalar-bilan-ozaro-tasiri', now(), now()),
        (146, 145, 147, 133, 13, 'Suvda erimaydigan asoslarning qizdirilganda parchalanishi', 'suvda-erimaydigan-asoslarning-qizdirilganda-parchalanishi', now(), now()),
        (147, 146, 148, 133, 14, 'Metall gidroksidlarining olinishi, ularga kislota va ishqor eritmalarining ta''siri', 'metall-gidroksidlarining-olinishi-ularga-kislota-va-ishqor-eritmalarining-tasiri', now(), now()),
        (148, 147, 149, 133, 15, 'Kislotalarning metallar, asoslar, tuzlar bilan o''zaro ta''siri', 'kislotalarning-metallar-asoslar-tuzlar-bilan-ozaro-tasiri', now(), now()),
        (149, 148, 150, 133, 16, 'Tuz eritmalari bilan metallarning o''zaro ta''siri', 'tuz-eritmalari-bilan-metallarning-ozaro-tasiri', now(), now()),
        (150, 149, 151, 133, 17, 'Al, Cu, Zn, Cr, Fe metallarining suvda eriydigan tuzlari va ular asosida boradigan tajribalar', 'Al-Cu-Zn-Cr-Fe-metallarining-suvda-eriydigan-tuzlari-va-ular-asosida-boradigan-tajribalar', now(), now()),
        (151, 150, 152, 133, 18, 'Laboratoriya sharoitida ammiak va karbonat angidrid olish va ularning kimyoviy xossalarini tekshirish', 'laboratoriya-sharoitida-ammiak-va-karbonat-angidrid-olish-va-ularning-kimyoviy-xossalarini-tekshirish', now(), now()),
        (152, 151, 153, 133, 19, 'Laboratoriya sharoitida organik moddalarning olinishi va ularga xos sifat reaksiyalari', 'laboratoriya-sharoitida-organik-moddalarning-olinishi-va-ularga-xos-sifat-reaksiyalari', now(), now()),
        (153, 152, 154, 133, 20, 'Organik moddalarni olinishi va ular uchun sifat reaksiyalari', 'organik-moddalarni-olinishi-va-ular-uchun-sifat-reaksiyalari', now(), now()),
        (154, 153, 155, 133, 21, 'Glitserin va glukoza uchun sifat reaksiya', 'glitserin-va-glukoza-uchun-sifat-reaksiya', now(), now()),
        (155, 154, 156, 133, 22, 'Oqsillarga xos rangli reaksiyalar', 'oqsillarga-xos-rangli-reaksiyalar', now(), now());

-- 5-MODULE
insert into topics (id, prev_id, next_id, seq, title, path, created_at, updated_at)
values (156, 155, 157, 5, 'Reaksiyalar zanjiri asosida moddalarning o''zaro bir-biriga ta''sir o''tkazishi', 'reaksiyalar-zanjiri-asosida-moddalarning-ozaro-bir-biriga-tasir-otkazishi', now(), now());

insert into topics (id, prev_id, next_id, parent_id, seq, title, path, created_at, updated_at)
values
        (157, 156, 158, 156, 1, 'Anorganik moddalarning eng muhim sinflari o''rtasida o''zaro genetik bog''lanish', 'anorganik-moddalarning-eng-muhim-sinflari-ortasida-ozaro-genetik-boglanish', now(), now()),
        (158, 157, 159, 156, 2, 'Organik moddalar o''rtasida boradigan kimyoviy jarayonlar', 'organik-moddalar-ortasida-boradigan-kimyoviy-jarayonlar', now(), now()),
        (159, 158, 160, 156, 3, 'Noorganik va organik kimyodan olingan bilimlarni umumlashtirish', 'noorganik-va-organik-kimyodan-olingan-bilimlarni-umumlashtirish', now(), now()),
        (160, 159, 161, 156, 4, 'Kimyoviy reaksiyalarning qonuniyatlari haqidagi bilimlarni umumlashtirish orqali kimyoviy ishlab chiqarishning umumiy ilmiy asoslari yuzasidan olingan bilimlarni sistemaga solish', 'kimyoviy-reaksiyalarning-qonuniyatlari-haqidagi-bilimlarni-umumlashtirish-orqali-kimyoviy-ishlab-chiqarishning-umumiy-ilmiy-asoslari-yuzasidan-olingan-bilimlarni-sistemaga-solish', now(), now()),
        (161, 160, null, 156, 5, 'O''zbekistonda kimyo fani va kimyo sanoatining rivojlanish istiqbollari', 'ozbekistonda-kimyo-fani-va-kimyo-sanoatining-rivojlanish-istiqbollari', now(), now());

alter sequence topics_id_seq restart with 162;
----TOPIC

----TASK
--1
insert into tasks (id, topic_id, content_uz, content_ru, level, type, created_at, updated_at)
values (1, 1, '$^{107}Bh$ elementi tarkibida magnit kvant soni +3 bo''lgan nechta elektron mavjud?', 'Сколько электронов с магнитным квантовым числом +3 содержится в элементе $^{107}Bh$?', 'EASY', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (1, 1, '8', '8', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (2, 1, '14', '14', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (3, 1, '28', '28', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (4, 1, '4', '4', false, now(), now());

--2
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (2, '500 ml 0,04M li sirka kislota eritmasiga 0,16 mol sof sirka kislota qo''shilganda kislotaning dissotsilanish darajasi necha foizdan bir foizgacha kamayadi?', 'Когда к 500 мл 0,04М раствора уксусной кислоты добавляют 0,16 моль чистой уксусной кислоты, на сколько процентов снижается степень диссоциации кислоты — от скольких процентов до скольких процентов?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (5, 2, '3', '3', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (6, 2, '4', '4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (7, 2, '5', '5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (8, 2, '2', '2', false, now(), now());

--3
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (3, '16,8 g alken kaliy permanganat eritmasiga to''liq yuttirilishi natijasida kaliy permanganat eritmasining massasi 18 g ga kamaydi. Alkenning formulasini aniqlang.', 'При полном обесцвечивании 16,8 г алкена раствором перманганата калия масса раствора перманганата калия уменьшилась на 18 г. Определите формулу алкена.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (9, 3, '$C_3H_6$', '$C_3H_6$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (10, 3, '$C_2H_4$', '$C_2H_4$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (11, 3, '$C_5H_{10}$', '$C_5H_{10}$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (12, 3, '$C_4H_8$', '$C_4H_8$', false, now(), now());

--4
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (4, 'Magniy sulfidi va fosfidi aralashmasida fosfor atomlari metall atomlaridan 2,5 molga kam, oltingugurt atomlaridan 3,5 molga ko''p bo''lsa, aralashma gidrolizidan necha litr (n.sh.) fosfin hosil bo''ladi?', 'В смеси сульфида и фосфида магния атомов фосфора на 2,5 моль меньше, чем атомов металла, и на 3,5 моль больше, чем атомов серы. Сколько литров фосфина выделится при гидролизе смеси (н.у.)?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (13, 4, '89,6', '89,6', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (14, 4, '67,2', '67,2', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (15, 4, '33,6', '33,6', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (16, 4, '44,8', '44,8', false, now(), now());

--5
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (5, '15$^\circ$C dagi eruvchanligi 44 g bo''lgan tuzning to''yingan eritmasi 35$^\circ$C gacha isitilganda 80 g tuz erib, to''yingan eritma hosil qiladi. 15$^\circ$C dagi to''yingan eritmaning massasini (g) hisoblang. S(35$^\circ$C)=60', 'При растворимости соли 44 г при 15$^\circ$C, насыщенный раствор при нагревании до 35$^\circ$C может растворить в себе 80 г соли, образуя насыщенный раствор. Найдите массу насыщенного раствора при 15$^\circ$C. S(35$^\circ$C)=60', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (17, 5, '720', '720', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (18, 5, '725', '725', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (19, 5, '715', '715', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (20, 5, '710', '710', false, now(), now());

--6
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (6, '$X_{(g)}$ + $2Y_{(g)}$ $\rightleftarrows$ $3Z_{(g)}$ sistemada reaksiya tezligi 0,6 mol/(l$\cdot$min). Agar tezlik konstantasi $k_1$ = 0,05 l$^2$/(mol$^2$ $\cdot$ min) va $X$ moddaning konsentratsiyasi 3M bo''lsa, $Y$ modda konsentratsiyasini (M) hisoblang', 'В системе: $X_{(г)}$ + $2Y_{(г)}$ $\rightleftarrows$ $3Z_{(г)}$ скорость прямой реакции составляет 0,6 моль/(л$\cdot$мин). Если константа скорости $k_1$ = 0,05 л$^2$/(моль$^2$ $\cdot$ мин), а концентрация вещества $X$ равна 3М, найдите концентрацию вещества $Y$ (М).', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (21, 6, '2', '2', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (22, 6, '4', '4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (23, 6, '3', '3', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (24, 6, '9', '9', false, now(), now());

--7
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (7, 'Qaysi zarrachalar juftligida xlorning oksidlanish darajasi manfiy qiymatga ega?', 'В какой паре частиц степень окисления хлора имеет отрицательное значение?', 'EASY', 'THEORETICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (25, 7, 'ClBr$_3$ va ClF$_4$', 'ClBr$_3$ и ClF$_4$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (26, 7, 'PCl$_3$ va SCl$_2$', 'PCl$_3$ и SCl$_2$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (27, 7, 'ClO$^-_4$ va HCl', 'ClO$^-_4$ и HCl', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (28, 7, 'Cl$_2$O$_7$ va CCl$_4$', 'Cl$_2$O$_7$ и CCl$_4$', false, now(), now());

--8
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (8, 'Etanol va sirka kislota aralashmasini to''liq neytrallash uchun 80 g 6,25%li $NaOH$ eritmasi sarflandi. Xuddi shunday massali aralashma o''zaro to''liq ta''sirlashib ($H^+$ ishtirokida) 8,8 g murakkab efir hosil qiladi. Dastlabki aralashma massasini (g) toping.', 'Для полного нейтрализования смеси этанола и уксусной кислоты израсходовано 80 г 6,25%-ного раствора NaOH. Такая же по массе смесь, прореагировав между собой (в присутствии $H^+$), образует 8,8 г сложного эфира. Найдите массу исходной смеси (г).', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (29, 8, '13,25', '13,25', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (30, 8, '12,1', '12,1', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (31, 8, '11,75', '11,75', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (32, 8, '10,6', '10,6', false, now(), now());

--9
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (9, '$pH$=13 bo''lgan eritmada qaysi ion bo''lishi mumkin?<br>1) $K^+$; 2) $NH^+_4$; 3) $Sr^{2+}$; 4) $Cu^{2+}$', 'Какие ионы могут присутствовать в растворе с $pH$=13?<br>1) $K^+$; 2) $NH^+_4$; 3) $Sr^{2+}$; 4) $Cu^{2+}$', 'EASY', 'THEORETICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (33, 9, '1, 2, 3, 4', '1, 2, 3, 4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (34, 9, '1, 3, 4', '1, 3, 4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (35, 9, '1, 4', '1, 4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (36, 9, '1, 3', '1, 3', false, now(), now());

--10
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (10, '30 g $FeO$ va $CuO$ dan iborat aralashma mo''l miqdordagi ammiak bilan qaytarildi. Olingan metallar 294 g 30%li $HNO_3$ kislota eritmasi bilan to''liq ta''sirlasha olsa, $FeO$ massasini (g) aniqlang. (Reaksiya natijasida $NO$ hosil bo''ladi.)', 'Смесь из 30 г $FeO$ и $CuO$ восстановили избытком аммиака. Полученные металлы полностью прореагировали с 294 г 30%-ной азотной кислоты. Определите массу $FeO$ (г) в исходной смеси. (В результате реакции образуется $NO$.)', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (37, 10, '27', '27', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (38, 10, '36', '36', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (39, 10, '18', '18', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (40, 10, '9', '9', false, now(), now());

--11
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (11, '$X$ atomining radiusi - $R_1$, ionining radiusi esa - $R_2$. Bunga ko''ra quyidagi ifodalardan qaysilari to''g''ri?<br>1) $R_1$<$R_2$ bo''lsa, atom elektron olgan; 2) ion anion bo''lsa, $R_1$>$R_2$ bo''ladi; 3) atomdan elektron olish iondan elektron olish qiyinroq bo''lsa, $R_1$>$R_2$; 4) $R_1$>$R_2$ bo''lsa, atomning protonlari ionning protonlaridan kam.', 'Радиус атома $X$ - $R_1$, радиус иона - $R_2$. Какие из следующих утверждений верны?<br>1) Если $R_1 < R_2$, значит атом присоединил электрон; 2) Если ион — анион, то $R_1 > R_2$; 3) Если электрон труднее оторвать от атома, чем от иона, то $R_1 > R_2$; 4) Если $R_1 > R_2$, то у атома меньше протонов, чем у иона.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (41, 11, '1, 3', '1, 3', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (42, 11, '2, 4', '2, 4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (43, 11, '2, 3', '2, 3', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (44, 11, '1, 4', '1, 4', false, now(), now());

--12
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (12, 'Xlor gazi ikkiga ajratildi va birinchi qismi sovuq, ikkinchi qismi qaynoq o''yuvchi natriy eritmasi bilan to''liq reaksiyaga kirishdi. Har ikkala reaksiya uchun bir xil miqdorda $NaOH$ sarflangan bo''lsa, xlorning qancha qismi birinchi reaksiya uchun sarflangan?', 'Хлорный газ был поделен на две части: первая часть полностью прореагировала с холодным раствором едкого натрия, вторая — с горячим. Если в обоих случаях было израсходовано одинаковое количество $NaOH$, то какая доля хлора пошла на первую реакцию?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (45, 12, '3/8', '3/8', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (46, 12, '5/8', '5/8', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (47, 12, '3/4', '3/4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (48, 12, '1/2', '1/2', false, now(), now());

--13
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (13, '400 ml 1,5 molyarli kaliy gidrosulfit va 200 ml kaliy sulfit eritmalari aralashtirildi. Ushbu eritmaga 200 ml kaliy gidroksid eritmasi qo''shilganda, eritmadagi kaliy gidrosulfit konsentratsiyasi 0,5 mol/l gacha kamaydi. Eritmaga qo''shilgan kaliy gidroksid eritmasining konsentratsiyasini (mol/l) hisoblang.', 'Смешали 400 мл 1,5-молярного раствора калий гидросульфита и 200 мл раствора калий сульфита. После добавления 200 мл раствора калий гидроксида концентрация гидросульфита в растворе снизилась до 0,5 моль/л. Определите концентрацию раствора калий гидроксида, который был добавлен (моль/л).', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (49, 13, '0,6', '0,6', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (50, 13, '1,0', '1,0', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (51, 13, '0,4', '0,4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (52, 13, '0,8', '0,8', false, now(), now());

--14
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (14, '11,4 g etan va siklopropan aralashmasining hajmi 6,72 l (n.sh.) bo''lsa, aralashmaga maksimal qancha (l, n.sh.) xlor birikishi mumkin?', 'Масса смеси этана и циклопропана составляет 11,4 г, а её объём при н.у. - 6,72 л. Какой максимальный объём хлора (л, при н.у.) может присоединиться к этой смеси?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (53, 14, '2,24', '2,24', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (54, 14, '1,12', '1,12', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (55, 14, '3,36', '3,36', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (56, 14, '4,48', '4,48', false, now(), now());

--15
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (15, 'Gaz holidagi alkin va vodorod aralashmasi $(D(He)=2,4)$ $\textit{Ni}$ katalizatori ustidan o''tkazilganda bromli suvni rangsizlantirmaydigan gazlar arlashmasi $(D(He)=4)$ olindi. Alkinning molyar massasini (g/mol) hisoblang.', 'Смесь алкина и водорода в газообразном состоянии $(D(He)=2,4)$ пропустили над катализатором $\textit{Ni}$. В результате получена газовая смесь с плотностью по гелию $(D(He)=4)$, которая не обесцвечивает бромную воду. Определите молярную массу алкина (г/моль).', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (57, 15, '70', '70', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (58, 15, '54', '54', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (59, 15, '26', '26', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (60, 15, '40', '40', false, now(), now());

--16
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (16, 'Nitrit kislotaning nisbiy molekular massasini hisoblang.', 'Вычислите относительную молекулярную массу нитритной кислоты.', 'EASY', 'THEORETICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (61, 16, '63', '63', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (62, 16, '82', '82', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (63, 16, '47', '47', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (64, 16, '98', '98', false, now(), now());

--17
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (17, '$C_6H_{12}O_6$ + $KMnO_4$ + $H_2SO_4$ $\rightarrow$ $CO_2$ + $MnSO_4$ + $K_2SO_4$ + $H_2O$<br>Ushbu reaksiyadagi koeffitsiyentlar yig''indisini aniqlang.', '$C_6H_{12}O_6$ + $KMnO_4$ + $H_2SO_4$ $\rightarrow$ $CO_2$ + $MnSO_4$ + $K_2SO_4$ + $H_2O$<br>Определите сумму коэффициентов в этой реакции.', 'EASY', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (65, 17, '197', '197', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (66, 17, '185', '185', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (67, 17, '195', '195', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (68, 17, '180', '180', false, now(), now());

--18
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (18, '48 g III valentli noma''lum metall oksidi $H_2$ va $CO$ aralashmasi yordamida qaytarildi. Reaksiya natijasida 5,4 g suv va 26,4 g $CO_2$ olingan bo''lsa, metallni toping.', '48 г оксида неизвестного III валентного металла восстановили смесью $H_2$ и $CO$. В результате реакции образовалось 5,4 г воды и 26,4 г $CO_2$. Определите металл.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (69, 18, '$Mn$', '$Mn$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (70, 18, '$Cr$', '$Cr$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (71, 18, '$Fe$', '$Fe$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (72, 18, '$Al$', '$Al$', false, now(), now());

--19
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (19, '1 $\cdot$ 10$^{-4}$ mol polistirol 52 g bo''lsa, polimerlanish darajasini hisoblang.', 'Если 1 $\cdot$ 10$^{-4}$ моль полистирола имеет массу 52 г, вычислите степень полимеризации.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (73, 19, '4000', '4000', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (74, 19, '500', '500', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (75, 19, '5000', '5000', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (76, 19, '400', '400', false, now(), now());

--20
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (20, 'Metall, kovalent va ion bog''lanishli moddalar ketma-ketligini toping.', 'Установите последовательность веществ с металлической, ковалентной и ионной связью.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (77, 20, '$Ag_2S$, $S_8$, KJ', '$Ag_2S$, $S_8$, KJ', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (78, 20, '$Ag$, $NO_2$, $SrF_2$', '$Ag$, $NO_2$, $SrF_2$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (79, 20, '$Zn$, $HF$, $NH_3$', '$Zn$, $HF$, $NH_3$', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (80, 20, '$Pb$, $F_2$, $H_3AsO_4$', '$Pb$, $F_2$, $H_3AsO_4$', false, now(), now());

--21
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (21, 'Chumoli va sirka kislotadan iborat 24,4 g aralashmani neytrallash uchun 250 g 8%li natriy gidroksid sarflangan bo''lsa, hosil bo''lgan organik mahsulotlar massalarini (g) aniqlang.', 'Смесь из муравьиной и уксусной кислот массой 24,4 г нейтрализовали 250 г 8%-ного раствора гидроксида натрия. Определите массы (г) образовавшихся органических продуктов.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (81, 21, '18,4; 6', '18,4; 6', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (82, 21, '13,6; 10,8', '13,6; 10,8', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (83, 21, '20,4; 16,4', '20,4; 16,4', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (84, 21, '27,2; 8,2', '27,2; 8,2', false, now(), now());

--22
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (22, '0,2 mol metoksimetan massasini (g) hisoblang.', 'Рассчитайте массу (г) 0,2 моль метоксиметана.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (85, 22, '9,2', '9,2', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (86, 22, '8,4', '8,4', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (87, 22, '8,8', '8,8', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (88, 22, '9,6', '9,6', false, now(), now());

--23
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (23, '$F^-$ ionidagi valent elektronlar sonini aniqlang.', 'Определите количество валентных электронов в ионе $F^-$.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (89, 23, '8', '8', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (90, 23, '9', '9', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (91, 23, '10', '10', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (92, 23, '7', '7', false, now(), now());

--24
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (24, 'Quyidagi o''zgarishlar asosida fosfor tutgan $X$ va $Y$ moddalarnining molyar massalari (g/mol) yig''indisini toping.<br>$P$ $\xrightarrow{(O_2(mo''l)/t^\circ)}$ ... $\xrightarrow{(Ca(OH)_2, (mo''l))}$ ... $\xrightarrow{(SiO_2+C/t^\circ)}$ ... $\xrightarrow{HNO_3(kons)/t^\circ}$ $Y$', 'На основе следующих превращений найдите сумму молярных масс (г/моль) веществ $X$ и $Y$, содержащих фосфор.<br>$P$ $\xrightarrow{(O_2(избыт)/t^\circ)}$ ... $\xrightarrow{(Ca(OH)_2, (избыт.))}$ ... $\xrightarrow{(SiO_2+C/t^\circ)}$ ... $\xrightarrow{HNO_3(конц)/t^\circ}$ $Y$', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (93, 24, '452', '452', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (94, 24, '234', '234', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (95, 24, '341', '341', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (96, 24, '408', '408', false, now(), now());

--25
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (25, 'Qaysi reagentlardan foydalanib bir bosqichda metanal olish mumkin?', 'Из каких реагентов можно получить метаналь в один этап?', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (97, 25, '$CH_3OH$/$Cu$, t', '$CH_3OH$/$Cu$, t', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (98, 25, '$C_2H_2$/$H_2O$, $H^+$, $Hg^{2+}$', '$C_2H_2$/$H_2O$, $H^+$, $Hg^{2+}$', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (99, 25, '$C_2H_5OH$/$CuO$, t', '$C_2H_5OH$/$CuO$, t', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (100, 25, '$CO$, $2H_2$/t, p', '$CO$, $2H_2$/t, p', false, now(), now());

--26
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (26, 'Benzol + $Cl_{2(mo''l)}$ $\xrightarrow{\text{quyosh nuri}}$ ...<br>Reaksiya turi va olingan organik modda molekular massasini ko''rsating.', 'Бензол + $Cl_{2(избыт)}$ $\xrightarrow{\text{солнеч. луч}}$ ...Укажите тип реакции и молекулярную массу полученного органического вещества.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (101, 26, 'almashinish; 112,5', 'замещение; 112,5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (102, 26, 'o''rin olish; 285', 'замещение; 285', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (103, 26, 'almashinish; 181,5', 'замещение; 181,5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (104, 26, 'birikish; 291', 'присоединение; 291', false, now(), now());

--27
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (27, '250 g 19,5%li simob (II)-nitrat eritmasi elektroliz qilinganda, eritma massasi 50,55 g ga kamaydi. Elektroliz jarayonida ishtirok etgan suv massasini (g) hisoblang.', 'При электролизе 250 г 19,5%-ного раствора нитрата ртути (II) масса раствора уменьшилась на 50,55 г. Вычислите массу воды (г), участвовавшей в процессе электролиза.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (105, 27, '11,7', '11,7', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (106, 27, '19,8', '19,8', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (107, 27, '20,7', '20,7', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (108, 27, '12,6', '12,6', false, now(), now());

--28
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (28, 'Etanol va to''yingan bir asosli aminokislotadan hosil bo''lgan 39,75 g murakkab efirning gidrolizi uchun 4,5 g suv sarflangan bo''lsa, aminokislota molyar massasini (g/mol) hisoblang.', 'Если для гидролиза 39,75 г сложного эфира, полученного из этанола и насыщенной одноосновной аминокислоты, израсходовано 4,5 г воды, вычислите молярную массу (г/моль) аминокислоты.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (109, 28, '117', '117', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (110, 28, '89', '89', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (111, 28, '131', '131', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (112, 28, '103', '103', false, now(), now());

--29
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (29, '$XYO_3$ + 2$HCl$ $\rightarrow$ $XCl_2$ + $YO_2$ + $H_2O$<br>31,2 g $XYO_3$ reaksiyaga kirishganda 19,2 g $YO_2$ va 0,3$\cdot$$N_A$ ta $H_2O$ molekulasi hosil bo''ldi. Olingan tuzning massasini (g) hisoblang.', '$XYO_3$ + 2$HCl$ $\rightarrow$ $XCl_2$ + $YO_2$ + $H_2O$<br>При реакции 31,2 г $XYO_3$ образовалось 19,2 г $YO_2$ и 0,3$\cdot$$N_A$ молекул воды. Рассчитайте массу (г) полученной соли.', 'MEDIUM', 'PRACTICAL', now(), now());

insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (113, 29, '40,5', '40,5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (114, 29, '33,3', '33,3', true, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (115, 29, '28,5', '28,5', false, now(), now());
insert into answers (id, task_id, value_uz, value_ru, correct, created_at, updated_at)
values (116, 29, '43,5', '43,5', false, now(), now());

--30
insert into tasks (id, content_uz, content_ru, level, type, created_at, updated_at)
values (30, 'Molekulalarni tarkibidagi $\pi$- va $\sigma$-bog''lar yig''indisi ortib borishi tartibida joylashtiring.<br>1) oltingugurt (IV)-oksid; 2) metanal; 3) vodorod peroksid; 4) chumoli kislota; 5) gipoxlorit kislota.', 'Расположите молекулы в порядке увеличения суммы $\pi$- и $\sigma$-связей в их составе.<br>1) оксид серы (IV); 2) метаналь; 3) пероксид водорода; 4) муравьиная кислота; 5) хлорноватистая кислота.', 'MEDIUM', 'PRACTICAL', now(), now());

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