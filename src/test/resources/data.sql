INSERT INTO `tbl_prefecture` (`prefecture_id`, `prefecture_kana`, `prefecture`, `prefecture_code`) VALUES ('01', 'ｱｷﾀｹﾝ', '秋田県', '05');

INSERT INTO `tbl_city` (`city_id`, `code`, `city_kana`, `city`, `prefecture_id`) VALUES ('01', '05207', 'ﾕｻﾞﾜｼ', '湯沢市', '01');

INSERT INTO `tbl_old_post` (`old_post_id`, `old_post_code`) VALUES ('01', '012');

INSERT INTO `tbl_post` (`post_id`, `post_code`, `update_show`, `change_reason`, `multi_area`) VALUES ('01', '0120833', '0', '0', '0');

INSERT INTO `tbl_area` (`area_id`, `area_kana`, `area`, `city_id`, `chome_area`, `koaza_area`, `multi_post_area`, `post_id`, `old_post_id`) VALUES ('01', 'ｶｯｸｲｻﾜﾔﾏ', 'カツクイ沢山', '01', '0', '0', '0', '01', '01');
