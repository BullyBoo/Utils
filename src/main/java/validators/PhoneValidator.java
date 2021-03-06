/*
 * Copyright (C) 2017 BullyBoo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BullyBoo on 16.02.2017.
 */

@SuppressWarnings("all")
public class PhoneValidator{

    private final static Pattern mts = Pattern.compile("^9(1(6|0(4|0(9|[0-8]\\d)|[1-3]\\d|5\\d|6([0-3]|5|[7-9]|4\\d|6\\d)|" +
            "7([1-2]|[5-9]|0\\d|[3-4]\\d)|[8-9]\\d)|1(1|7|9|0([0-3]|[8-9]|[4-7]\\d)|[2-5]\\d|6([0-4]|[6-9]|5\\d)|8\\d)|" +
            "2([1-2]|6|0([1-4]|0\\d|[5-6]\\d|7([0-4]|[7-9]|[5-6]\\d)|[8-9]\\d)|[3-5]\\d|[7-9]\\d)|3(7|[0-6]\\d|8\\d|" +
            "9([0-7]|9|8\\d))|5([0-4]|[5-9]\\d)|7([4-5]|0([1-5]|[8-9]|0\\d|[6-7]\\d)|[1-3]\\d|[6-9]\\d)|8([0-1]|3|[5-6]" +
            "|2\\d|4\\d|[7-9]\\d)|4(0(0|[2-5]|1\\d|[6-9]\\d)|1([0-1]|[5-9])|[2-3]\\d|4[0-2]|5([4-9]|3([0-8]|9[0-2]))|[6-9]" +
            "\\d)|9(0\\d|1([0-2]|[4-9]|3([0-6]|[8-9]))|[2-3]\\d|4(0|[2-9]|1\\d)|[5-6]\\d|7([0-7]|9|8\\d)|8\\d|9([0-5]|[8-9]" +
            "|[6-7]\\d)))|78(0|[7-8]|1[0-4]|2([0-2]|6|5[5-9]|7\\d))|8(1(1|2[0-5]|3([0-1]|[4-5]|2[0-4]|6[0-4]|9[5-9])|4(0" +
            "|[2-8]|1\\d)|5([0-1]|[5-7]|2[0-4])|6([0-1]|[8-9]|5[0-4])|7\\d|8([0-5]|[7-9]|6[0-4])|9\\d)|2([5-6]|1(0|4|[6-9]" +
            "|[1-3]\\d|5\\d)|2\\d|3([0-8]|9\\d)|4\\d|7\\d|8(0|2|4|[7-9]|1\\d|3\\d|[5-6]\\d)|9\\d)|0(2([3-4]|6|9|5[0-3])|" +
            "3([0-8]|9[0-4])|5([0-6]|[7-8]\\d)|6([2-5]|[7-8]|6\\d|9[0-6])|7\\d|808[0-5])|3(0(0|2|1([1-9]|0\\d)|3[0-3]|" +
            "5\\d|7(0|5|7))|1\\d|2([0-4]|[7-9]|[5-6]\\d)|3([0-1]|[3-5]|[7-9]|2\\d|6\\d)|4[0-6]|5(0|[2-4]|7|1\\d|[5-6]\\d|" +
            "8\\d|9([0-3]|[5-9]|4\\d))|6([0-1]|3|9|2\\d|6(00|11)|7{3}))|4(1([0-1]|[3-7]|9|2\\d|8([0-4]|[8-9]))|2(0|2|[7-9" +
            "]|1[0-4]|5(0|5)|6[0-5]))|5(0[0-4]|9([1-2]|[6-7]|9))|6(7([0-1]|[4-9]|[2-3]\\d)|9([0-2]|[5-9]|[3-4]\\d))|" +
            "7(0(0|[2-4]|[6-9]|1\\d|5\\d)|1(0|[2-9]|1\\d)|2([1-2]|[4-9]|0\\d|3\\d)|3\\d|4([0-5]|[7-8]|6\\d|9\\d)|5([0-5]|" +
            "[8-9]|[6-7]\\d)|6([0-7]|9|8\\d)|7([0-2]|[4-9]|3\\d)|8(0|[2-9]|1\\d)|9\\d)|8(0([0-7]|9|8\\d)|1(0|[2-8]|1\\d)|" +
            "[2-3]\\d|4([0-1]|[3-4]|9|2\\d|[5-7]\\d|8([0-3]|[6-9]))|5([0-4]|[6-8]|5\\d|9\\d)|6([3-4]|[8-9]|[0-2]\\d|[5-7]\\d)" +
            "|7([0-5]|8|[6-7]\\d|9\\d)|8\\d|9([0-4]|7|9|[5-6]\\d|8\\d))|9(0([0-2]|[5-6]|[8-9]|[3-4]\\d)|1([0-8]|9\\d)|" +
            "2([0-8]|9\\d)|3([3-5]|6([0-2]|[5-9]))|4(2|[4-9]|3[0-5])|5\\d|6([0-7]|8[0-6]|9\\d)|[7-9]\\d))|0(2(08|3(4|1[5-9]|" +
            "5[2-4])|2(0(0|[3-9])|4[1-3])|7(12|4[6-7]))|8(35|5([2-3]|6))|1(26[0-1]|959)|47(3[5-9]|299))|50(23|9(3|4[0-4])|88[8-9]))\\d+$");

    private final static Pattern megafon = Pattern.compile("^9(2(6|1(3|0([1-9]|0\\d)|1(0|[2-9]|1\\d)|2\\d|[4-5]\\d|6([1-9]|0\\d)|" +
            "7([4-9]|[0-3]\\d)|8([1-3]|[6-9]|0\\d|[4-5]\\d)|9([0-8]|9\\d))|2(1|[8-9]|0\\d|2([0-3]|[6-9]|[4-5]\\d)|3([0-8]|9\\d)|" +
            "[4-5]\\d|6([0-8]|9\\d)|7([0-4]|[6-9]|5\\d))|5([0-5]|6[0-6]|[7-8]\\d|9(0|3|8|1\\d|2(0|[2-9])|4[0-8]|6([0-1]|[7-9])|" +
            "7(0|[4-9])|9\\d))|7(4|0\\d|1([2-5]|[7-9]|[0-1]\\d|6\\d)|2([0-6]|9|[7-8]\\d)|3\\d|5\\d|6([0-2]|5|7|9|[3-4]\\d|6\\d|" +
            "8\\d)|7([0-8]|9\\d)|[8-9]\\d)|8(1|5|0(5|9|[0-4]\\d|[6-8]\\d)|3([0-2]|[4-6]|[8-9]|3\\d|7\\d)|4([0-6]|[8-9]|7\\d)|" +
            "6([0-4]|7|[5-6]\\d|[8-9]\\d)|7([0-1]|[5-9]|[2-4]\\d)|8([0-4]|[5-9]\\d)|9(0|[1-9]\\d)|2(\\d\\d))|9([5-6]|9|0(4|[0-3]\\d|" +
            "[5-9]\\d)|1([0-1]|[3-4]|6|[8-9]|2\\d|5\\d|7\\d)|2([4-6]|[0-3]\\d|[7-9]\\d)|3(6|[8-9]|0([2-9]|[0-1]\\d)|[1-3]\\d|4(1|3|" +
            "[5-9]|0\\d|2\\d|4\\d)|5\\d|7\\d)|4([0-4]|6|8|5\\d|7\\d|9\\d)|7([0-2]|5|[7-9]|[3-4]\\d|6\\d)|8([3-4]|7|0[0-2]|1[3-9]|2\\d|" +
            "[5-6]\\d|[8-9]\\d))|0(0\\d|1([2-3]|[5-9]|[0-1]\\d|4\\d)|[2-9]\\d)|3(0(2|0([1-9]|00)|1\\d|3\\d|4[5-9]|5[0-5])|1\\d|2(0|" +
            "[2-9]|1\\d)|3\\d|4([0-4]|[6-9]|5\\d)|5([0-4]|[7-9]|[5-6]\\d)|6([0-5]|[7-9]|6\\d)|7([0-3]|6|9|[4-5]\\d|7([0-6]|[8-9]|7\\d)" +
            "|8([2-6]|8|[0-1]\\d|7\\d|9\\d))|8(1|0\\d|2([0-7]|8[0-1])))|4(0([0-1]|2[0-2]|4[0-1])|1\\d|2([0-8]|9\\d)|[3-4]\\d|5([0-7]|9" +
            "|8\\d)|6([0-5]|7|6\\d|[8-9]\\d)|7([0-3]|[5-7]|4\\d|[8-9]\\d)|8([0-8]|9\\d)|9(2|1[5-9]|3\\d|4[0-5])))|3(1([2-3]|4[0-1]|5" +
            "([0-3]|8|4[0-3]|7[6-9]|9\\d)|6(0|1[0-8])|8(5|0[0-5])|9(0|[5-9]|1[0-1])|00[0-8]|70[0-3])|0(0([4-5]|05|1(1|4|2[0-6])|3([0-4]" +
            "|7)|6(3|9)|7([0-4]|6)|8[4-9]|9([0-1]|6))|1([0-2]|[5-9]|3[0-7])|2([4-9]|0[2-9]|1\\d|2([0-4]|5[0-5]))|3([4-6]|[8-9]|0[0-6]|" +
            "2[0-1]|30|70)|4([0-2]|7[0-5])|6[7-9]|[7-8]\\d)|2(0(1|9|5\\d|60)|1([1-2]|00)|2(3|0([0-1]|3|7|9)|4[7-9]|5[0-7])|3[0-3]|4([0-2]" +
            "|[7-8]|3\\d|40)|5([3-5]|60)|6([0-1]|80)|8[4-6])|3(3([2-3]|0(0|[2-3]|1\\d|4\\d)|1([0-2]|4)|4[0-1])|1(00|6[0-7])|200|9(3[0-5]|" +
            "9(2|[4-9]|1[5-9]|3\\d)))|7(0\\d|1([1-9]|0\\d)|[2-3]\\d|4([0-8]|9\\d)|5([1-8]|0\\d|9\\d)|6([1-9]|0\\d)|7([0-4]|[7-9]|[5-6]\\d)|" +
            "[8-9]\\d)|8(1([0-3]|[5-6]|4[1-9]|7[0-2])|2(0|9[4-9])|3(0|4|1[0-6]|3([1-5]|[7-9])|5[0-8])|4([0-7]|98)|5([0-2]|3\\d|4(0|[4-9])|" +
            "5[0-2])|7([8-9]|0[0-2]|7[7-9])|8(0|7|9|1[0-1]|6[1-9]|8\\d)|9(0|1[0-7]|8([4-6]|9|7[0-1])|9\\d)|0([0-2]\\d|3[0-8]|7[5-9]|8[0-2])|" +
            "6(5[0-4]|9[0-4]))|97[0-5]|4(100|4(01|31|41|61|7(1|6)|81|91))|6(0{3}|1{3}|2{3}|3{3}|5{3}|6(00|66)|7{3}))|02(22|33[0-4])|5128|" +
            "9(619|9(0(0([5-8]|4[5-9]|9\\d)|1[3-9]|2[3-9]|3[3-9]|4[1-9]|5([0-4]|6)|6[3-9]|7([1-9]|0[3-9])|81|9(0[3-9]|[1-4]\\d|7[1-9]|" +
            "[8-9]\\d))|1(0([1-4]|7|6[5-9]|8\\d)|1[6-9]|22|35|4[6-9]|5(2|9|0[3-9]|1\\d|3\\d|4[0-7])|6[0-1]|8(2|[6-7]|0[3-9]|1\\d|3[0-7]|" +
            "5[3-9]|8[0-7])|9([1-2]|[6-7]|0[3-9]|3[0-7]|5[3-9]|8\\d))|2(5(3|[6-7]|[1-2]\\d|4\\d|[8-9]\\d)|6([4-9]|1[5-9]|[2-3]\\d)|7(3|" +
            "[7-8]|0[3-9]|[1-2]\\d|4[0-7]|5[3-9]|6\\d|9\\d)|8([2-3]|[6-8]|0[3-9]|1\\d|4[0-7]|5[3-9]|9\\d)|9([1-2]|6|8|0[3-9]|3\\d|4[0-7]" +
            "|5[3-9]|7\\d|9[0-7])|3(0[2-9]|1[0-2]))|3(0([1-4]|6|0[3-9]|5\\d|[7-8]\\d|9[0-7])|1([2-4]|[6-9]|5\\d)|2(0|[3-4]|[6-9]|[1-2]\\d" +
            "|5\\d)|3(1|[6-8]|0[3-9]|2\\d|[4-5]\\d|9[0-7])|4[3-9]|5[3-7]|6([1-2]|[5-9]|0[3-9]|[3-4]\\d)|7([0-5]|[6-7]\\d|8[0-4])|9([1-4]" +
            "|6|0\\d|5\\d|7\\d)|8(0[3-9]|[1-9]\\d))|4(0[3-9]|1[1-9]|2(1|[4-9]|3[7-9])|3([2-4]|[8-9]|5[3-9]|[6-7]\\d)|61|7([1-4]|[7-9])" +
            "|8([1-3]|[6-8]|0[3-9]|4[0-7]|5[3-9]|9\\d)|9(6|8|0[3-9]|[1-4]\\d|7\\d|9[0-4])|49[2-9])|5(0[3-7]|4([1-6]|0[3-9]|7[0-2])|" +
            "5([1-7]|0[3-9]|8\\d)|7([2-9]|1[7-9])|9[3-9]|80\\d)|6(5[8-9]|6([1-4]|0[5-9]|5\\d)|90[3-9])|7(0([1-4]|[6-9])|2[8-9]|" +
            "3([1-4]|[6-9])|4([1-2]|4|[6-9]|0[3-9]|3\\d)|5([1-4]|[6-9])|6([1-3]|[6-7]|0[3-9]|4[0-2]|5[3-9]|8\\d|9[0-7])|7(4|6|8))|949)))\\d+$");

    private final static Pattern bilain = Pattern.compile("^9(0(3([1-2]|5|7|0([0-1]|[2-9]\\d)|3(9|[0-8]\\d)|4(3|[0-2]\\d|[4-9]\\d)" +
            "|6([0-2]|[6-8]|[3-5]\\d|9\\d)|8(0|2|5|1\\d[3-4]\\d|[6-9]\\d)|9(3|[6-7]|[0-2]\\d|[4-5]\\d|[8-9]\\d))|5(5|7|1(1|[3-4]|" +
            "0\\d|2\\d|[5-9]\\d)|2([0-2]|[4-8]|3\\d|9\\d)|3([1-3]|5|9|0\\d|4\\d|[6-8]\\d)|4(1|[4-6]|0\\d|[2-3]\\d|[7-9]\\d)|6([0-3]|[5-8]" +
            "|4\\d|9\\d)|8([0-1]|[3-4]|[8-9]|2\\d|[5-7]\\d)|9([0-1]|3|[5-8]|2\\d|4\\d|9\\d)|0(\\d\\d))|6(0|7|1([0-1]|[2-9]\\d)|2(1" +
            "|[3-7]|0\\d|2\\d|[8-9]\\d)|3([0-2]|5|8|[3-4]\\d|[6-7]\\d|9\\d)|4([6-7]|[0-5]\\d|[8-9]\\d)|5(3|[0-2]\\d|[4-9]\\d)|8(0|[3-4]" +
            "|6|[1-2]\\d|5\\d|[7-9]\\d)|9(2|6|[0-1]\\d|[3-5]\\d|[7-9]\\d)|6(\\d\\d))|9(9|0([0-2]|5|[7-8]|[3-4]\\d|6\\d|9\\d)|1([0-3]" +
            "|[5-8]|4\\d|9\\d)|2(0|[1-9]\\d)|3(3|8|[0-2]\\d|[4-7]\\d|9\\d)|4([0-3]|5|4\\d|[6-9]\\d)|5(1|8|0\\d|[2-7]\\d|9\\d)|6\\d|7([5-6]|8|" +
            "[0-4]\\d|7\\d|9\\d)|8([0-7]|[8-9]\\d))|2(0[5-7]|5(2|5([3-7]|9)))|462|8(4([4-5]|6[0-4])|9[6-9])|03(3[5-9]|4[0-4]))" +
            "|6(2(9|0([0-5]|7|6\\d|[8-9]\\d)|1([0-4]|[7-9]|[5-6]\\d)|2(0|[2-7]|1\\d|[8-9]\\d)|3([0-1]|6|[2-5]\\d|[7-9]\\d)" +
            "|4(0|[2-4]|9|1([0-7]|9)|5\\d|60|[7-8]\\d)|5([2-3]|[5-6]|[0-1]\\d|4\\d|[7-9]\\d)|6([8-9]|[0-7]\\d)|7([0-2]|9|" +
            "[3-8]\\d)|8(1|3|[6-7]|0\\d|2\\d|[4-5]\\d|[8-9]\\d))|3(6|0(4|8|[0-3]\\d|[5-7]\\d|9\\d)|1(0|3|8|[1-2]\\d|[4-7]\\d|" +
            "9\\d)|2(9|[0-8]\\d)|3([0-2]|4|8|3\\d|[5-7]\\d|9\\d)|4([0-2]|[4-7]|3\\d|[8-9]\\d)|5(0|2|4|[7-9]|1\\d|3\\d|5\\d|" +
            "6[2-8])|7([0-2]|[4-9]|3[0-8])|8([0-2]|7|9|[3-6]\\d|8\\d)|9([0-2]|[6-9]|[3-5]\\d))|5([0-3]|4([0-4]|[6-7]|5\\d|" +
            "[8-9]\\d)|5\\d|6([0-6]|8|7\\d|9\\d)|7(0|[5-8]|[1-4]\\d|9\\d)|8(2|4|[7-9]|[0-1]\\d|3\\d|[5-6]\\d)|9([0-8]|9\\d))" +
            "|6([0-1]|3|2([7-8]|06|2[6-7]|39|4(0|9)|50|60|9([0-3]|7))|7([0-2]|5|9|3[0-4]|4\\d|6\\d|7([0-7]|9)|8\\d))|7([0-2]" +
            "|3([0-3]|6|9|4\\d|5([0-4]|[7-9])|[7-8]\\d)|4([0-2]|[4-6]|8|3[0-4]|7\\d|9[0-7])|5(0|3|9|1[0-4]|2[0-3]|5[0-3]|6[0-4]" +
            "|7[0-4]|8[0-2])|6([0-1]|[3-6]|2[0-5]|7[0-4]|8[0-4]|96)|7([2-3]|6|9|0[0-7]|1\\d|[4-5]\\d|7\\d|8(0|[8-9]))|8(0|[2-3]" +
            "|[5-6]|8|1([0-2]|9)|4[0-2]|7\\d|9\\d)|9(0\\d|1([0-4]|[6-9])|[2-3]\\d|4([0-2]|[8-9])|[5-7]\\d|8([0-4]|[7-9])|9\\d))" +
            "|8(0|[4-8]|1([0-2]|8|3\\d|4([0-3]|[8-9])|5[0-7]|6([0-2]|[5-9])|7\\d|9[0-6])|2([6-7]|0[0-5]|10|46|8[0-7])|3([1-9]|00)" +
            "|9\\d)|9([1-2]|0([1-9]|0\\d)|3[0-4]|6([0-5]|[8-9]|[6-7]\\d)|7([0-3]|9|4\\d|5([0-2]|9)|6[0-6]|7([0-2]|[8-9]))|8(0|1[0-1]" +
            "|2[0-5]))|0([0-2]\\d|3(0|[3-9]|[1-2]\\d)|4(1|5|8|0\\d|[2-4]\\d|[6-7]\\d|9\\d)|5(0|3|5|8|[1-2]\\d|4\\d|[6-7]\\d|9\\d)" +
            "|6(0|2|6|8|1\\d|[3-5]\\d|7\\d|9\\d)|7(0|2|6|8|1\\d|[3-5]\\d|7\\d|9\\d)|8([1-3]|[7-8]|0\\d|[4-6]\\d|9\\d)|9([0-2]|" +
            "[4-5]|[8-9]|3\\d|[6-7]\\d))|1(0(4|[6-8]|[0-3]\\d|5\\d|9\\d)|1([7-9]|[0-6]\\d)|2(0|3|5|[7-9]|[1-2]\\d|4\\d|6\\d)" +
            "|3([0-2]|6|8|[3-5]\\d|7\\d|9\\d)|4\\d|5([0-5]|[8-9]|[6-7]\\d)|6([3-4]|[6-8]|[0-2]\\d|5\\d|9\\d)|7([0-2]|[3-9]\\d)|" +
            "8(0|5|7|[1-2]\\d|3[0-8]|4\\d|6\\d|[8-9]\\d)|9([0-6]|8|7\\d|9\\d))|4(0([0-1]|3|6|8|2\\d|[4-5]\\d|7\\d|9[0-8])|1([0-2]|" +
            "4|7|3[0-7]|[5-6]\\d|[8-9]\\d)|2([0-1]|4|[6-9]|[2-3]\\d|5\\d)|3([2-9]|[0-1]\\d)|4(0|[3-4]|6|9|[1-2]\\d|5\\d|[7-8]\\d)" +
            "|5\\d|6(0|[2-6]|8|1\\d|7\\d|9\\d)|7\\d|8([0-1]|3|[8-9]|2\\d|[4-7]\\d)|9([0-5]|[7-8]|6\\d|9\\d)))|5(10[0-2]|32[0-2]))\\d+$");

    private final static Pattern tele2 = Pattern.compile("^9(0(1(5|7|1(8|0([0-5]|7|9)|1([1-5]|[7-9])|2([0-3]|[5-6]|8)|3(0|1([0-4]" +
            "|5(2|[5-6])))|52|65|9(0|3|8))|3([3-6]|8)|4(0|2|1([5-6]|[8-9])|4([0-2]|9|5[0-4])|6(1|4)|7([0-1]|[5-6]|[8-9])|8[7-9]" +
            "|9[0-3])|6([5-6]|0(0|[7-9])|1([0-4]|[7-8])|2(1|[3-5])|3([0-3]|4[0-4])|4([0-1]|[6-7])|7[0-4])|8(1|6|0[0-1]|22|7[0-1])" +
            "|9(0|11|23|3(0|3|5|7)|4[0-1]|52|6(1|[4-6]|8)|8([2-4]|[7-9])|9([0-1]|3|8))|0(0[2-9]|1([0-2]|[4-9]|3([0-4]|5([5-6]" +
            "|9)|6([0-1]|[3-4]|6)))|9([2-3]|[5-9]))|2(00|4[0-3]))|0(0([0-2]|[5-9])|1[0-3]|2([3-8]|19|2\\d|9\\d)|3(2|6|[0-1]\\d|" +
            "3[0-4]|4[5-9]|5\\d|7[0-4])|4(9|0[5-9]|[1-5]\\d|6([0-4]|[7-9]|5[5-9]|6\\d)|7(0|2|[4-9]|1\\d|3\\d)|8([0-2]|[4-7]" +
            "|3\\d|8\\d|9[0-4]))|5([0-4]|5([0-4]|[6-9])|[6-9]\\d)|6([2-9]|0\\d|10)|9(5|9|0[1-9]|[1-4]\\d|[6-8]\\d))|2(0(0|4" +
            "|9|1\\d)|1(0|3|[6-7]|9|2\\d|4\\d|5([2-4]|[7-9])|8([0-7]|9))|2(1|3\\d|4[4-8]|5[0-2]|8\\d)|3(0|[8-9]|1[0-4]|2([5-6]" +
            "|9)|5[5-8]|6\\d)|4(3|5|0[3-8]|1[1-9]|2([0-3]|[5-9])|6[5-8])|5([3-4]|0(4|7)|1\\d|5([0-2]|8)|[6-7]\\d|8([0-2]|[8-9]))|" +
            "6(5|8|6[6-9]|7[3-9]|9[5-9])|7(0|[6-8]|4[0-2]|5\\d)|8(4|8|1[0-1]|2[1-3])|9([0-2]|4|[6-7]|3\\d|5([0-2]|[6-9])|8\\d|9([0-2]|" +
            "[6-9])))|4(0\\d|1([0-5]|[8-9])|2(0|[2-3]|5|[8-9]|1\\d|4\\d|[6-7]\\d)|3([0-7]|9)|4[0-4]|5([0-3]|5|[7-9])|6([0-1]|" +
            "[3-9])|7[5-9]|8([2-3]|6|9|5\\d)|9([0-2]|[6-7]|9|5[5-9]))|8(0(1|[4-9]|2[0-6]|3[0-4])|1\\d|2([0-1]|3|8|2([0-6]|[8-9])" +
            "|9\\d)|3([0-1]|2\\d)|4([7-8]|6[5-9]|9[0-4])|5([0-1]|[4-5]|[7-9])|6([4-8]|0([0-2]|[4-7])|9\\d)|7\\d|8[0-2]|9([4-5]|" +
            "3\\d)))|77(1|[3-8]|2[5-9]|9\\d)|5(0(0\\d|1[0-8]|2([1-2]|[4-7])|3(1|[3-9]|0\\d|2\\d)|4[0-3]|5([7-9]|6[5-9])|6([0-2]|" +
            "[7-9]|6[0-4])|7\\d|8([0-7]|9)|9([0-2]|5|[7-9]|4[5-9]|6\\d))|1(0(3|[5-9])|1\\d|2([0-2]|79|9[5-9])|3([0-3]|[6-9]|" +
            "[4-5]\\d)|4([0-2]|[4-9])|[5-8]\\d|9([0-1]|9[7-9]))|2(0(0|[2-7]|1\\d|8[5-9]|9\\d)|1([0-2]|5|9|[6-8]\\d)|2\\d|3(0|" +
            "[5-9]|1[0-4])|[4-5]\\d|6([0-3]|6[5-9]|79|8(1|3|6))|7([6-9]|4[5-9]|5([0-2]|[4-9]|3[1-9]))|[8-9]\\d)|3(0(1|[7-9]|2\\d|" +
            "3[0-8]|59|6\\d)|1(0|[2-9]|1\\d)|2([3-4]|[6-9]|5\\d)|3([0-7]|9)|4(0|[2-3]|[5-9]|1(0|[2-9]|1\\d)|4\\d)|5([0-1]|3|[5-9]|" +
            "2\\d|4\\d)|6[1-9]|7\\d|8([0-1]|[3-4]|[6-8]|5\\d|9\\d)|9([0-6]|8|7\\d|9([8-9]|0\\d|1([0-3]|[8-9])|2[0-5]|3[0-1]|4([0-3]" +
            "|[8-9])|5[2-9]|6([4-5]|[8-9])|7[0-8])))|8(39|5(08|1[0-2]|417)|6(4[5-8]|5(0|[3-9])|6([2-4]|6|8|5[5-9]|7\\d|9\\d)|" +
            "7(0|1[0-4])|80)))|9(22[8-9]|30([0-2]|3([0-4]|5([0-1]|2([0-1]|3))))|5(1[8-9]|4[0-2]|2(0([0-2]|[4-9]|3[3-9])|1(0|" +
            "1[0-7]|35)))|6(1[5-8]|7(0|[6-8]|5[5-9]|9\\d)|8(0|1[0-4]|5[0-4])|90|0(0\\d|1(0|[3-9]))|20[0-4]|69{3})|9(8[8-9]" +
            "|9[0-2]|7799)|1(99\\d|0171)))\\d+$");

    private final static Pattern yota = Pattern.compile("^9(9(5(95|55(3|[5-9]|[0-2]\\d|4\\d))|6(3(6|0[3-9]|[1-5]\\d|[7-9]\\d)|" +
            "6([5-7]|[0-4]\\d|8\\d|9[0-8])|9([7-8]|[1-6]\\d|9[0-8])|4([0-4]\\d|5[0-4])|5(\\d\\d))|9(2([0-1]|2(2|0[2-9]|1\\d|" +
            "[3-9]\\d)|3(3|[5-8]|1[3-9]|2\\d|4\\d|9\\d)|4([1-3]|[6-8]|0[2-9]|[4-5]\\d|9\\d)|5(0|5)|6(0|1[0-4])|7(0[0-2]|4[8-9]|" +
            "5[0-2])|8(0[0-2]|4[8-9]|5[0-2])|9(0[0-2]|4[8-9]|5[0-2]|9[8-9]))|6(3|0(0|[3-4]|[6-8]|[1-2]\\d|5\\d|9\\d)|1(1|[4-7]|" +
            "9|0\\d|[2-3]\\d|8\\d)|2([4-9]|[0-3]\\d)|4([0-6]|8|7\\d|9\\d)|5[0-7]|6([6-9]|0[0-4])|7([3-9]|0[0-2])|8([2-5]|1\\d|" +
            "6\\d)|9([1-9]|0[0-2]))|8[0-7]|9[6-9]|0(0([0-3]|4[0-4])|40|5[7-9]|8(0|[2-9])|9(5|6\\d|70)|10[0-2]|30[0-2]|60[0-2]|" +
            "70[0-2])|1(0(0|5|9|6[0-4])|1[0-5]|2([0-1]|[3-9])|3([0-4]|[6-9])|4[0-5]|5([5-8]|0[0-2]|4[8-9])|6[2-9]|7([0-6]|" +
            "[7-9]\\d)|9(9|0[0-2]|3[8-9]|4\\d|5[0-2])|8(0[0-2]|3[8-9]|4\\d|5[0-2]|8[8-9]|9\\d))|3(1[0-1]|9[8-9]|0(0[0-2]|9[8-9])|" +
            "3(0[0-2]|9[8-9])|40[0-2]|5(0[0-2]|9[8-9])|60[0-2]|7(8[5-9]|9\\d)|80[0-2])|4(10|2(0|2|3[0-6])|3([0-1]|5[0-2])" +
            "|4([0-3]|[5-8]|9[0-1])|5\\d|6(0|[2-9])|7(0|[5-6]\\d)|9(5|0[0-2]|9[5-9])|00[0-2]|8(0[0-2]|4[8-9]|5[0-2]))|5(1([3-5]|" +
            "[0-2]\\d|[6-9]\\d)|2(0|2|[4-8]|1\\d|3\\d|9\\d)|3(1|[3-7]|0\\d|2\\d|[8-9]\\d)|4(8|0[0-2]|7[3-9]|9\\d)|5(9|0[0-2])|" +
            "6\\d|7(0|1[0-6])|8[1-9]|0(0[0-2]|9[8-9])|90[0-2])|7(0(0|5)|1\\d|2([0-2]|4|[6-7]|3\\d|5\\d)|3(0|5)|4(5|0[0-2])|5(0|5)|" +
            "7([0-3]|5)|8([1-3]|[7-8]|0\\d|[4-6]\\d|9\\d)|9([3-4]|8|[0-2]\\d|[5-7]\\d|9\\d)|6(0[0-2]|4[3-9]|5[0-2]|9[8-9])))|" +
            "1{3}(1|0\\d|[2-9]\\d))|585(37([1-2]|0[3-9]|3\\d|40)|41([2-3]|1[8-9]|[4-5]\\d|6\\d)))\\d+$");


    private static final Pattern PHONE_NUMBER = Pattern.compile("^\\+*\\d{10}$");

    private enum Operator{
        MTS,
        MEGAFON,
        BILAIN,
        TELE2,
        YOTA
    }

    public static boolean checkValid(String number){
        if(number == null || number.length() != 10){
            return false;
        }

        String phoneNumber = number.replaceAll("[^\\d]", "");

        Matcher matcher = PHONE_NUMBER.matcher(phoneNumber);
        return matcher.matches();
    }

    public static Operator checkOperator(String number){
        if(number == null || number.length() != 10){
            return null;
        }

        String phoneNumber = number.replace(" ", "");

        if(checkValidMts(phoneNumber)){
            return Operator.MTS;
        } else if (checkValidMegafon(phoneNumber)){
            return Operator.MEGAFON;
        } else if (checkValidBilain(phoneNumber)){
            return Operator.BILAIN;
        } else if (checkValidTele2(phoneNumber)){
            return Operator.TELE2;
        } else if (checkValidYota(phoneNumber)){
            return Operator.YOTA;
        }
        return null;
    }

    private static boolean checkValidMts(String number){
        if(number == null || number.length() != 10){
            return false;
        }

        Matcher matcher = mts.matcher(number);
        return matcher.matches();
    }

    private static boolean checkValidMegafon(String number){
        if(number == null || number.length() != 10){
            return false;
        }

        Matcher matcher = megafon.matcher(number);
        return matcher.matches();
    }

    private static boolean checkValidBilain(String number){
        if(number == null || number.length() != 10){
            return false;
        }

        Matcher matcher = bilain.matcher(number);
        return matcher.matches();
    }

    private static boolean checkValidTele2(String number){
        if(number == null || number.length() != 10){
            return false;
        }

        Matcher matcher = tele2.matcher(number);
        return matcher.matches();
    }

    private static boolean checkValidYota(String number){
        if(number == null || number.length() != 10){
            return false;
        }

        Matcher matcher = yota.matcher(number);
        return matcher.matches();
    }
}
