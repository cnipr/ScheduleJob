package com.cnipr.schedule;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetSearchFormat {

	public String ReplaceAliaseWithName(String s) {
		// System.out.println("com.trs.was.PTools.ReplaceAliaseWithName-->已经进入 s = "
		// + s);
		try {
			if (s == null && s == "") {
				return s;
			}

			// s = ReGetFormatString(s);

			s = s.toLowerCase();
			// s = s.replaceAll("\\,","\\\\,");
			// s = s.replaceAll("/","\\\\/");
			// s = s.replaceAll("-","\\-");
			s = s.replaceAll(" =", "=");

			s = s.replaceAll("ian=", "国际申请=");
			s = s.replaceAll("ian,", "国际申请,");
			s = s.replaceAll(",ian", ",国际申请");
			s = s.replaceAll("国际申请\\\\,", "国际申请,");

			s = s.replaceAll("ipn=", "国际公布=");
			s = s.replaceAll("ipn,", "国际公布,");
			s = s.replaceAll(",ipn", ",国际公布");
			s = s.replaceAll("国际公布\\\\,", "国际公布,");

			s = s.replaceAll("dan=", "分案原申请号=");
			s = s.replaceAll("dan,", "分案原申请号,");
			s = s.replaceAll(",dan", ",分案原申请号");
			s = s.replaceAll("分案原申请号\\\\,", "分案原申请号,");

			s = s.replaceAll("ipd=", "颁证日=");
			s = s.replaceAll("ipd,", "颁证日,");
			s = s.replaceAll(",ipd", ",颁证日");
			s = s.replaceAll("颁证日\\\\,", "颁证日,");

			s = s.replaceAll("an=", "申请号=");
			s = s.replaceAll("an,", "申请号,");
			s = s.replaceAll(",an", ",申请号");
			s = s.replaceAll("申请号\\\\,", "申请号,");

			s = s.replaceAll("ad=", "申请日=");
			s = s.replaceAll("ad,", "申请日,");
			s = s.replaceAll(",ad", ",申请日");
			s = s.replaceAll("ad>", "申请日>");
			s = s.replaceAll("ad<", "申请日<");
			s = s.replaceAll("申请日\\\\,", "申请日,");
			
			s = s.replaceAll("pnm=", "公开（公告）号=");
			s = s.replaceAll("pnm,", "公开（公告）号,");
			s = s.replaceAll(",pnm", ",公开（公告）号");
			s = s.replaceAll("公开（公告）号\\\\,", "公开（公告）号,");

			s = s.replaceAll("pn=", "专利号=");
			s = s.replaceAll("pn,", "专利号,");
			s = s.replaceAll(",pn", ",专利号");
			s = s.replaceAll("专利号\\\\,", "专利号,");

			s = s.replaceAll("pd=", "公开（公告）日=");
			s = s.replaceAll("pd,", "公开（公告）日,");
			s = s.replaceAll(",pd", ",公开（公告）日");
			s = s.replaceAll("pd>", "公开（公告）日>");
			s = s.replaceAll("pd<", "公开（公告）日<");
			s = s.replaceAll("公开（公告）日\\\\,", "公开（公告）日,");

			s = s.replaceAll("ti=", "名称=");
			s = s.replaceAll("ti,", "名称,");
			s = s.replaceAll(",ti", ",名称");
			s = s.replaceAll("名称\\\\,", "名称,");

			s = s.replaceAll("ab=", "摘要=");
			s = s.replaceAll("ab,", "摘要,");
			s = s.replaceAll(",ab", ",摘要");
			s = s.replaceAll("摘要\\\\,", "摘要,");

			s = s.replaceAll("pic=", "主分类号=");
			s = s.replaceAll("pic,", "主分类号,");
			s = s.replaceAll(",pic", ",主分类号");
			s = s.replaceAll("主分类号\\\\,", "主分类号,");

			s = s.replaceAll("sic=", "分类号=");
			s = s.replaceAll("sic,", "分类号,");
			s = s.replaceAll(",sic", ",分类号");
			s = s.replaceAll("分类号\\\\,", "分类号,");

			s = s.replaceAll("pa=", "申请（专利权）人=");
			s = s.replaceAll("pa,", "申请（专利权）人,");
			s = s.replaceAll(",pa", ",申请（专利权）人");
			s = s.replaceAll("申请（专利权）人\\\\,", "申请（专利权）人,");

			s = s.replaceAll("in=", "发明（设计）人=");
			s = s.replaceAll("in,", "发明（设计）人,");
			s = s.replaceAll(",in", ",发明（设计）人");
			s = s.replaceAll("发明（设计）人\\\\,", "发明（设计）人,");

			s = s.replaceAll("ar=", "地址=");
			s = s.replaceAll("ar,", "地址,");
			s = s.replaceAll(",ar", ",地址");
			s = s.replaceAll("地址\\\\,", "地址,");

			s = s.replaceAll("agc=", "专利代理机构=");
			s = s.replaceAll("agc,", "专利代理机构,");
			s = s.replaceAll(",agc", ",专利代理机构");
			s = s.replaceAll("专利代理机构\\\\,", "专利代理机构,");

			s = s.replaceAll("agt=", "代理人=");
			s = s.replaceAll("agt,", "代理人,");
			s = s.replaceAll(",agt", ",代理人");
			s = s.replaceAll("代理人\\\\,", "代理人,");

			s = s.replaceAll("pr=", "优先权=");
			s = s.replaceAll("pr,", "优先权,");
			s = s.replaceAll(",pr", ",优先权");
			s = s.replaceAll("优先权\\\\,", "优先权,");

			s = s.replaceAll("fa=", "同族专利项=");
			s = s.replaceAll("fa,", "同族专利项,");
			s = s.replaceAll(",fa", ",同族专利项");
			s = s.replaceAll("同族专利项\\\\,", "同族专利项,");

			s = s.replaceAll("ct=", "范畴分类=");
			s = s.replaceAll("ct,", "范畴分类,");
			s = s.replaceAll(",ct", ",范畴分类");
			s = s.replaceAll("范畴分类\\\\,", "范畴分类,");

			s = s.replaceAll("co=", "国省代码=");
			s = s.replaceAll("co,", "国省代码,");
			s = s.replaceAll(",co", ",国省代码");
			s = s.replaceAll("国省代码\\\\,", "国省代码,");
			
			s = s.replaceAll("clm=", "权利要求书=");
			s = s.replaceAll("clm,", "权利要求书,");
			s = s.replaceAll(",clm", ",权利要求书");
			s = s.replaceAll("权利要求书\\\\,", "权利要求书,");

			s = s.replaceAll("cl=", "主权项=");
			s = s.replaceAll("cl,", "主权项,");
			s = s.replaceAll(",cl", ",主权项");
			s = s.replaceAll("主权项\\\\,", "主权项,");

			s = s.replaceAll("ft=", "说明书=");
			s = s.replaceAll(",ft", ",说明书");
			s = s.replaceAll("ft,", "说明书,");
			// s =
			// s.replaceAll("权利要求书\\,说明书\\,说明书附图\\,附件\\,","权利要求书,说明书,说明书附图,附件,");
			// s =
			// s.replaceAll("权利要求书\\\\,说明书\\\\,说明书附图\\\\,附件","权利要求书,说明书,说明书附图,附件");

			s = s.replaceAll("主权项\\\\,", "主权项,");
			s = s.replaceAll("权利要求书\\\\,", "权利要求书,");
			s = s.replaceAll("说明书\\\\,", "说明书,");
			s = s.replaceAll("说明书附图\\\\,", "说明书附图,");
			s = s.replaceAll("附件\\\\,", "附件,");

			// 将多字段联合检索中的 = 替换为 +=
			s = s.replaceAll(",申请号=", ",申请号+=");
			s = s.replaceAll(",专利号=", ",专利号+=");
			s = s.replaceAll(",公开（公告）号=", ",公开（公告）号+=");
			s = s.replaceAll(",名称=", ",名称+=");
			s = s.replaceAll(",摘要=", ",摘要+=");
			s = s.replaceAll(",主分类号=", ",主分类号+=");
			s = s.replaceAll(",分类号=", ",分类号+=");
			s = s.replaceAll(",申请（专利权）人=", ",申请（专利权）人+=");
			s = s.replaceAll(",发明（设计）人=", ",发明（设计）人+=");
			s = s.replaceAll(",主权项=", ",主权项+=");
			s = s.replaceAll(",地址=", ",地址+=");
			s = s.replaceAll(",专利代理机构=", ",专利代理机构+=");
			s = s.replaceAll(",代理人=", ",代理人+=");
			s = s.replaceAll(",优先权=", ",优先权+=");
			s = s.replaceAll(",同族专利项=", ",同族专利项+=");
			s = s.replaceAll(",范畴分类=", ",范畴分类+=");
			s = s.replaceAll(",国省代码=", ",国省代码+=");
			s = s.replaceAll(",附件=", ",附件+=");
			s = s.replaceAll(",国际公布=", ",国际公布+=");
			s = s.replaceAll(",国际申请=", ",国际申请+=");
			s = s.replaceAll(",分案原申请号=", ",分案原申请号+=");
			s = s.replaceAll(",颁证日=", ",颁证日+=");

			// s = s.replaceAll("*","%");
			s = s.replaceAll("!c!", "\\\\/");
			// s = replaceSpecialString(s,"*","%");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}

	public String ReGetFormatString(String s) {
		// 我打算把这个函数改造成增加百分号，删掉函数AddExtendString
		// s="主分类号=('g06f11' or 'g01r31/28' or 'g06f12/14' or 'g06f12/16')";
		// System.out.println(">"+s);
		String str = "";
		// 优先权=(1996.11.5 US 60/030,213)
		// 优先权=(1996.11.5% US% 60/030,213%)
		// 优先权=(1996.11.5 US 60/030,213%)
		/*
		 * if(s.indexOf(" to ")==-1 && s.indexOf(" and ")==-1 &&
		 * s.indexOf(" or ")==-1 && s.indexOf(" not ")==-1 &&
		 * s.indexOf(" xor ")==-1 && s.indexOf(" adj ")==-1 &&
		 * s.indexOf(" equ# ")==-1 && s.indexOf(" pre# ")==-1 &&
		 * s.indexOf(" xor# ")==-1)
		 */
		String[] arrStr = s.split(" ");

		for (int i = 0; i < arrStr.length; i++) {
			// System.out.println("arrStr["+i+"]="+arrStr[i]);
			String tmpString = arrStr[i].trim();
			if (!tmpString.equals("to") && !tmpString.equals("and")
					&& !tmpString.equals("or") && !tmpString.equals("not")
					&& !tmpString.equals("xor") && !tmpString.equals("adj")
					&& tmpString.indexOf("equ#") == -1
					&& tmpString.indexOf("pre#") == -1
					&& tmpString.indexOf("xor#") == -1
					// && tmpString.indexOf("%")==-1 &&
					// tmpString.indexOf("?")==-1 && tmpString.indexOf("'")<0){
					&& tmpString.indexOf("'") == -1) {
				// System.out.println("tmpString="+tmpString);
				/*
				 * if(tmpString.indexOf("'")>-1) { Pattern pattern =
				 * Pattern.compile("[']+[\\S]+[']+"); Matcher matcher =
				 * pattern.matcher(tmpString);
				 * 
				 * if (matcher.find()) { System.out.println(matcher.group()); //
				 * s = //matcher.replaceAll("chrTitle like '%" + matcher.group()
				 * + "%'"); //System.out.println(s); Pattern patterninner =
				 * Pattern.compile("[^'][\\S]+[^']"); Matcher matcherinner =
				 * patterninner.matcher(matcher.group()); if
				 * (matcherinner.find()) {
				 * System.out.println(matcherinner.group());
				 * tmpString="'"+matcherinner.group()+"%'"; } } } else
				 */
				// System.out.println(tmpString);

				if (tmpString.indexOf(")") != -1
						&& tmpString.indexOf("※※") == -1) {
					if (tmpString.indexOf(")") > 0) {
						if (!(tmpString.substring(tmpString.indexOf(")") - 1,
								tmpString.indexOf(")"))).equals("%")) {
							tmpString = arrStr[i].substring(0, arrStr[i]
									.indexOf(")"))
									+ "%"
									+ arrStr[i].substring(arrStr[i]
											.indexOf(")"));
						}
					}
					// tmpString=arrStr[i].substring(0,arrStr[i].lastIndexOf("(")+1)+"%"+arrStr[i].substring(arrStr[i].lastIndexOf("(")+1,arrStr[i].indexOf(")"))+"%"+arrStr[i].substring(arrStr[i].indexOf(")"));
				} else {
					// tmpString=tmpString.substring(0,tmpString.indexOf("=")+1)+"%"+tmpString.substring(tmpString.indexOf("=")+1)+"%";
					if (!tmpString.substring(tmpString.length() - 1,
							tmpString.length()).equals("%")
							&& tmpString.indexOf("※※") == -1 && !tmpString.equals(",")) {
						tmpString += "%";
					}
				}

				str = str + " " + tmpString + " ";
			} else {
				str = str + " " + arrStr[i] + " ";
			}
		}

		// str=str.trim();
		// System.out.println("合成...>"+str);

		return str;
	}

	public String ChangeOrderAliaseWithValue(String s) {
		String returnVal = "";
		if (s.indexOf("/") != -1 && s.indexOf("=") == -1) {
			returnVal = InFormatString(s);
		} else
			returnVal = s;
		return returnVal;
	}

	@SuppressWarnings("unchecked")
	public ArrayList InFormatString_left_OLD(String s) {
		String strString = s;
		String strTmpString = "";
		String[] arrString;

		ArrayList al = new ArrayList();
		// al.add("winsun");

		if (s.length() > 500)
			arrString = new String[300];
		else {
			arrString = new String[200];
		}

		int k = 0;
		int bracketcount = 0;
		boolean bPreBreak = false; // /
		boolean bPreBreak1 = false;// =
		boolean bf = false;
		int p = 0;// =的位置

		while (strString.length() > 0) {
			strTmpString = strString.substring(0, 1);

			int charflag = 0;
			if (strTmpString.equalsIgnoreCase("("))
				charflag = 1;
			if (strTmpString.equalsIgnoreCase(")"))
				charflag = 2;
			if (strTmpString.equalsIgnoreCase("/"))
				charflag = 3;
			if (strTmpString.equalsIgnoreCase("="))
				charflag = 4;
			if (strTmpString.equalsIgnoreCase(" "))
				charflag = 5;

			switch (charflag) {
			case 1:
				bracketcount--;

				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, al.get(k) + strTmpString);
				}
				break;
			case 2:
				bracketcount++;

				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, al.get(k) + strTmpString);
				}
				break;
			case 3:// 遇到/
				bracketcount = 0;

				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, al.get(k) + strTmpString);
				}
				bPreBreak = true;
				break;
			case 4:// 遇到=
				p = strString.length();
				bracketcount = 0;

				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, al.get(k) + strTmpString);
				}
				bPreBreak1 = true;// 和case 3就这点不同
				break;
			case 5:
				// (ti=(数字 or 数字?)) and (ti=(版权 or 权利 or 权限 or 著作权 or 知识产权))
				// (计算机 or 电脑)/ti and ti=(控制 or 方法)
				if (bPreBreak == true) {
					// 遇到=后bPreBreak1为true，再遇到第一个空格后就立刻截断
					// 与左右括号无关
					k++;

					if (al.size() == 0 || (k + 1) > al.size()) {
						al.add(k, strTmpString);
					} else if ((k + 1) == al.size()) {
						al.set(k, al.get(k) + strTmpString);
					}

					bracketcount = 0;// 最后将括号数清零，意义不大
					// bPreBreak=false;//应该意义不大，但还是写上，应该在bPreBreak1为true的后续处理中置为false
					bPreBreak = false;
				} else if (bf == true) {
					// 遇到=后开始数左右括号，当bracketcount为0时，再遇到的空格就立刻截断
					k++;

					if (al.size() == 0 || (k + 1) > al.size()) {
						al.add(k, strTmpString);
					} else if ((k + 1) == al.size()) {
						al.set(k, al.get(k) + strTmpString);
					}

					bracketcount = 0;// 最后将括号数清零
					bPreBreak1 = false;
					bf = false;
				} else if (bracketcount == 0) {
					bracketcount = 0;
					// bracketcount1=0;
					bPreBreak = false;
					bPreBreak1 = false;
					k++;

					if (al.size() == 0 || (k + 1) > al.size()) {
						al.add(k, strTmpString);
					} else if ((k + 1) == al.size()) {
						al.set(k, al.get(k) + strTmpString);
					}
				} else {
					if (al.size() == 0 || (k + 1) > al.size()) {
						al.add(k, strTmpString);
					} else if ((k + 1) == al.size()) {
						al.set(k, al.get(k) + strTmpString);
					}
				}
				break;
			default:
				/*
				 * if (k > arrString.length) { expand(arrString, k); } if
				 * (arrString[k] == null) arrString[k] = ""; arrString[k] =
				 * arrString[k] + strTmpString;
				 */
				// System.out.println("al.size()...>"+al.size());
				// System.out.println("k...>"+k);
				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, al.get(k) + strTmpString);
				}
				break;
			}

			/*
			 * (控制 or 方法))/ft 上面这种情况，遇到/后，就满足bPreBreak==true && bracketcount==0
			 * 所以还需要满足当前字符不是遇到/后的第一个字符，所以还要加上一个条件， 就是p!=strString.length()
			 * p是/的位置
			 */
			if (bPreBreak1 == true && bracketcount == 0
					&& strString.length() != p) {
				bf = true;
			}

			strString = strString.substring(1);
		}
		// A61K/pic and (ft=(计算机 or 电脑) and (控制 or 方法)/ft)
		/*
		 * int m=0; boolean bl=true; do{
		 * System.out.println("arrString["+m+"]="+arrString[m]); m++;
		 * }while(m<arrString.length && arrString[m]!=null);
		 * 
		 * 
		 * String returnVal = ""; for (int j = 0; j < arrString.length; j++) {
		 * if (arrString[j] != null && !arrString[j].equals("")) {
		 * returnVal=returnVal+add_prefix(arrString[j]);
		 * 
		 * } } returnVal = returnVal.replaceAll("  "," "); returnVal =
		 * returnVal.replaceAll("\\( ","("); // returnVal =
		 * returnVal.replaceAll("\\) ",")"); // returnVal =
		 * returnVal.replaceAll(" \\(",")"); returnVal =
		 * returnVal.replaceAll(" \\)",")"); returnVal =
		 * returnVal.replaceAll(" \\=","="); returnVal =
		 * returnVal.replaceAll("\\= ","=");
		 * 
		 * System.out.println("returnVal...>"+returnVal);
		 */
		Object[] objString = al.toArray();
		for (int j = 0; j < objString.length; j++) {
			arrString[j] = (String) objString[objString.length - j - 1];
		}
		// return arrString;
		ArrayList al1 = new ArrayList();
		for (int i = al.size() - 1; i >= 0; i--) {
			al1.add(al.size() - i - 1, al.get(i));
		}
		return al1;
	}

	@SuppressWarnings("unchecked")
	public ArrayList InFormatString_left(String s) {
		// s = "and wahaha) and (computer or accumulator)) and (a xor b))";
		// s = "(cl=energy and petro and accumulator) and (a xor b))";
		// s = "(energy/cl and petro and accumulator) and (a xor b))";

		s += " ";

		ArrayList al = new ArrayList();

		if (s.indexOf("/") > -1) {
			String strString = s.substring(s.indexOf("/"));

			String strTmpString = "";
			String strCurrent = s.substring(0, s.indexOf("/"));

			while (strString.length() > 0) {
				strTmpString = strString.substring(0, 1);

				// count_bracket():
				strCurrent += strTmpString;
				;

				if (strTmpString.trim().equals("")) {
					al.add(strCurrent);
					s = s.substring(strCurrent.length());
					break;
				}
				strString = strString.substring(1);
			}
		} else if (s.indexOf("=") > -1) {
			String strString = s.substring(s.indexOf("=") + 2);
			String strTmpString = "";
			String strCurrent = s.substring(0, s.indexOf("=") + 2);
			boolean bf = false;

			while (strString.length() > 0) {
				strTmpString = strString.substring(0, 1);

				// count_bracket():
				strCurrent = strCurrent + strTmpString;
				;

				int bracket_count = count_bracket(strCurrent
						.substring(strCurrent.indexOf("=")));

				if (bracket_count == 0) {
					bf = true;
				}

				if (strTmpString.trim().equals("") && bf) {
					al.add(strCurrent);
					s = s.substring(strCurrent.length());
					bf = false;
					break;
				}
				strString = strString.substring(1);
			}
		} else {
			al.add(s);
			return al;
		}
		// 上面的程序是把包含=或/的段落取出来
		/*********************************************************************/

		int bracketcount = count_bracket(s);

		if (bracketcount == 0) {
			al.add(s);
			return al;
		} else if (bracketcount != 0) {
			String strString = s;
			String strTmpString = "";

			String strCurrent = "";

			while (strString.length() > 0) {
				strTmpString = strString.substring(0, 1);

				// count_bracket():
				strCurrent = strCurrent + strTmpString;

				if (strTmpString.equals(")") && count_bracket(strCurrent) > 0) {
					al.add(" " + strCurrent.trim() + " ");
					strCurrent = "";
				}
				if (strTmpString.trim().equals("")) {
					if (strCurrent.trim().equals("and")
							|| strCurrent.trim().equals("or")
							|| strCurrent.trim().equals("not")
							|| strCurrent.trim().equals("xor")) {
						al.add(" " + strCurrent.trim() + " ");
						strCurrent = "";
					}
				}
				if (strTmpString.trim().equals("")
						&& count_bracket(strCurrent) == 0
						&& !strCurrent.trim().equals("")) {
					al.add(" " + strCurrent.trim() + " ");
					strCurrent = "";
				}

				strString = strString.substring(1);
			}
			if (!strCurrent.trim().equals("")) {
				al.add(" " + strCurrent.trim() + " ");
			}
		}

		// return arrString;
		ArrayList al1 = new ArrayList();
		for (int i = al.size() - 1; i >= 0; i--) {
			al1.add(al.size() - i - 1, al.get(i));
		}

		// System.out.println(al1.size());
		return al1;
	}

	@SuppressWarnings("unchecked")
	public String InFormatString(String s) {
		s = s.replaceAll("[ ]+", " ");

		String strString = " " + s;
		String strTmpString = "";
		ArrayList al = new ArrayList();
		ArrayList al_temp = new ArrayList();

		int k = 0;
		int bracketcount = 0;

		boolean bPreBreak = false; // /
		boolean bPreBreak1 = false;// =
		boolean bf = false;
		int p = 0;// /的位置
		while (strString.length() > 0) {
			strTmpString = strString.substring(strString.length() - 1);

			int charflag = 0;
			if (strTmpString.equalsIgnoreCase("("))
				charflag = 1;
			if (strTmpString.equalsIgnoreCase(")"))
				charflag = 2;
			if (strTmpString.equalsIgnoreCase("/"))
				charflag = 3;
			if (strTmpString.equalsIgnoreCase("="))
				charflag = 4;
			if (strTmpString.equalsIgnoreCase(" "))
				charflag = 5;

			switch (charflag) {
			case 1:
				bracketcount--;
				/*
				 * if (k > arrString.length) { expand(arrString, k); } if
				 * (arrString[k] == null) arrString[k] = ""; arrString[k] =
				 * strTmpString + arrString[k];
				 */
				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, strTmpString + al.get(k));
				}
				break;
			case 2:
				bracketcount++;
				/*
				 * if (k > arrString.length) { expand(arrString, k); } if
				 * (arrString[k] == null) arrString[k] = ""; arrString[k] =
				 * strTmpString + arrString[k];
				 */
				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, strTmpString + al.get(k));
				}
				break;
			case 3:// 遇到/
				p = strString.length();
				bracketcount = 0;
				/*
				 * if (k > arrString.length) { expand(arrString, k); } if
				 * (arrString[k] == null) arrString[k] = ""; arrString[k] =
				 * strTmpString + arrString[k];
				 */
				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, strTmpString + al.get(k));
				}
				bPreBreak = true;
				break;
			case 4:// 遇到=
				bracketcount = 0;
				/*
				 * if (k > arrString.length) { expand(arrString, k); } if
				 * (arrString[k] == null) arrString[k] = ""; arrString[k] =
				 * strTmpString + arrString[k];
				 */
				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, strTmpString + al.get(k));
				}
				bPreBreak1 = true;// 和case 3就这点不同
				break;
			case 5:
				// (ti=(数字 or 数字?)) and (ti=(版权 or 权利 or 权限 or 著作权 or 知识产权))
				// (计算机 or 电脑)/ti and ti=(控制 or 方法)

				// ((an=(PU) or 聚氨酯) or ab=(聚丙烯酸)) or ab=(PA)
				// 在程序的一开始增加了 String strString = " "+s;
				// 因为只有遇到空格才会判断是否有必要进行InFormatString_left的处理
				// ((an=(PU) or 聚氨酯)是需要进行InFormatString_left处理的
				// 但是由于此表达式左侧没有空格，所以在InFormatString的最下方进行了一番处理
				// 可以查找zzzzzzzzzzzzzzzzzzzzzzzzzzzzz
				if (bPreBreak1 == true) {
					// 遇到=后bPreBreak1为true，再遇到第一个空格后就立刻截断
					// 与左右括号无关
					// (sic=com or func) or energy
					// (sic=(com) or func) or energy
					// ((com/sic and digital) or func) or energy
					// 上面这三种情况，用count_bracket是没办法判断的，就不判断了，干脆统一使用InFormatString_left
					// if(count_bracket((String)al.get(k))!=0){
					// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					al_temp = InFormatString_left((String) al.get(k));
					for (int j = 0; j < al_temp.size(); j++) {
						if (al_temp.get(j) != null
								&& !al_temp.get(j).equals("")) {
							if (al.size() == 0 || (k + 1) > al.size()) {
								al.add(k, al_temp.get(j));
							} else if ((k + 1) == al.size()) {
								al.set(k, (String) al_temp.get(j));
							}
							k++;
						}
					}
					// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					// }else{k++;}

					if (al.size() == 0 || (k + 1) > al.size()) {
						al.add(k, strTmpString);
					} else if ((k + 1) == al.size()) {
						al.set(k, strTmpString + al.get(k));
					}
					bracketcount = 0;// 最后将括号数清零，意义不大
					// bPreBreak=false;//应该意义不大，但还是写上，应该在bPreBreak1为true的后续处理中置为false
					bPreBreak1 = false;
				} else if (bf == true) {
					// 遇到/后开始数左右括号，当bracketcount为0时，再遇到的空格就立刻截断

					/*
					 * ((两 or 双) and (麦克 or 传感器) and 定位)/AB or ((两 or 双) and (麦克
					 * or 传感器) and 定位)/TI ((两 or 双) and (麦克 or 传感器) and 定位)/TI
					 * ti=((两 or 双) and (麦克 or 传感器) and 定位)
					 * 又进行了InFormatString_left处理 ...(麦克 or 传感器)/ti and 定位)......
					 * "定位"后要加) 否则按照bracketcount==0这个条件，就能把"定位"单算作一个arrString
					 * 所以增加了下面这个bracketcount!=0的条件
					 */
					// if(count_bracket((String)al.get(k))!=0){
					if (((String) al.get(k)).indexOf("/") != -1
							&& ((String) al.get(k)).trim().substring(
									((String) al.get(k)).trim().indexOf("/"))
									.length() > 4) {
						// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						al_temp = InFormatString_left((String) al.get(k));
						for (int j = 0; j < al_temp.size(); j++) {
							if (al_temp.get(j) != null
									&& !al_temp.get(j).equals("")) {
								if (al.size() == 0 || (k + 1) > al.size()) {
									al.add(k, al_temp.get(j));
								} else if ((k + 1) == al.size()) {
									al.set(k, (String) al_temp.get(j));
								}
								k++;
							}
						}
						// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					} else {
						// ((((computer? or function) and (energy)/an and
						// ti=accumulator) and (a xor b)) or (x pre/10 t)) and
						// bellows/an
						// 又增加了这段else程序，原因是遇到上面的检索表达式
						// and (energy)/an
						// 原因是count_bracket(arrString[k])为0
						// 所以就不执行k++了
						// 但是又不能什么情况都执行k++
						// 否则，会出现arrString[n]为null，影响debug的显示，遇到null就不打印了
						k++;
					}
					// }else{k++;}

					// k++;

					if (al.size() == 0 || (k + 1) > al.size()) {
						al.add(k, strTmpString);
					} else if ((k + 1) == al.size()) {
						al.set(k, strTmpString + al.get(k));
					}

					bracketcount = 0;// 最后将括号数清零
					bPreBreak = false;
					bf = false;
				}
				/*
				 * else if(bLeftBracket==true) {
				 * //这段程序是最后加的，因为遇到了下面这个表达式，我疏忽了这种情况，就是既不包括/也不包括= //(b/pic and
				 * cn2005/an) or ((((computer? or function) and (energy)/an and
				 * ti=accumulator) and (a xor b)) or (x pre/10 t)) and
				 * bellows/an"; //上面的表达式分裂成：申请号=cn2005%) or ((((computer? or
				 * function%) //((((computer? or function%)中既没有/也没有=
				 * //是否可以把规律总结为遇到(后，第一个空格处就截断
				 * 
				 * //我增加了一个变量bLeftBracket，如果既不在/所界定的段落中，也不在=所界定的段落中（我在case
				 * 4时，执行了bLeftBracket=false;） //遇到(就把bLeftBracket设置为true //...or
				 * ((x or y) and ... //...or (x and y)) and ...
				 * 
				 * //遇到了下面这个检索表达式，所以把代码先注释掉了 //ipn=((生物 or 医药) and (计算机 or 电脑)
				 * and (控制 or 方法))
				 * 
				 * 
				 * if(count_bracket(arrString[k])!=0){
				 * //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				 * arrstr=InFormatString_left(arrString[k]); for (int j = 0; j <
				 * arrstr.length; j++) { if (arrstr[j] != null &&
				 * !arrstr[j].equals("")) { arrString[k]=""; if (k >
				 * arrString.length) { expand(arrString, k); }
				 * arrString[k]=arrstr[j]; k++; } }
				 * //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ }else{
				 * k++; }
				 * 
				 * //k++; if (k > arrString.length) { expand(arrString, k); } if
				 * (arrString[k] == null) arrString[k] = ""; arrString[k] =
				 * strTmpString + arrString[k];
				 * 
				 * bracketcount=0;//最后将括号数清零 bLeftBracket=false;
				 * 
				 * 
				 * if (k > arrString.length) { expand(arrString, k); } if
				 * (arrString[k] == null) arrString[k] = ""; arrString[k] =
				 * strTmpString + arrString[k];
				 * 
				 * bLeftBracket=false; }
				 */
				else if (bracketcount == 0) {
					bracketcount = 0;
					// bracketcount1=0;
					bPreBreak = false;
					bPreBreak1 = false;
					k++;

					if ((al.size() == 0 || (k + 1) > al.size())
							&& !strTmpString.trim().equals("")) {
						al.add(k, strTmpString);
					} else if ((k + 1) == al.size()) {
						al.set(k, strTmpString + al.get(k));
					}
				} else {
					if (al.size() == 0 || (k + 1) > al.size()) {
						al.add(k, strTmpString);
					} else if ((k + 1) == al.size()) {
						al.set(k, strTmpString + al.get(k));
					}
				}
				break;
			default:
				if (al.size() == 0 || (k + 1) > al.size()) {
					al.add(k, strTmpString);
				} else if ((k + 1) == al.size()) {
					al.set(k, strTmpString + al.get(k));
				}
				break;
			}

			/*
			 * (控制 or 方法))/ft 上面这种情况，遇到/后，就满足bPreBreak==true && bracketcount==0
			 * 所以还需要满足当前字符不是遇到/后的第一个字符，所以还要加上一个条件， 就是p!=strString.length()
			 * p是/的位置
			 */
			if (bPreBreak == true && bracketcount == 0
					&& strString.length() != p) {
				bf = true;
			}

			strString = strString.substring(0, strString.length() - 1);
		}
		// A61K/pic and (ft=(计算机 or 电脑) and (控制 or 方法)/ft)
		/*
		 * zzzzzzzzzzzzzzzzzzzzzzzzzzzzz
		 * if(count_bracket((String)al.get(k))!=0){
		 * if(((String)al.get(k)).indexOf("/")!=-1 &&
		 * ((String)al.get(k)).trim().
		 * substring(((String)al.get(k)).trim().indexOf("/")).length()>4){
		 * al_temp=InFormatString_left((String)al.get(k)); for (int j = 0; j <
		 * al_temp.size(); j++) { if (al_temp.get(j) != null &&
		 * !al_temp.get(j).equals("")) { if(al.size()==0 || (k+1)>al.size()){
		 * al.add(k,al_temp.get(j)); }else if((k+1)==al.size()){
		 * al.set(k,(String)al_temp.get(j)); } k++; } } } }
		 */
		String returnVal = "";
		int m = 0;
		// System.out.println(al.size());
		Iterator it = al.iterator();
		while (it.hasNext()) {
			m++;
			String str_temp = (String) it.next();
			if (!str_temp.trim().equals("")) {
				str_temp = add_prefix(str_temp.trim());
			}
			// System.out.println("arrString["+m+"]="+str_temp);
			returnVal = " " + str_temp + " " + returnVal;
		}
		// System.out.println(returnVal);
		// ++++++++++++++++++++++把多个连在一起的空格替换成一个空格++++++++++++++++++++++++++++
		Pattern pattern = Pattern.compile("[\\s]+");
		Matcher matcher = pattern.matcher(returnVal);

		while (matcher.find()) {
			// System.out.println(matcher.group());
			returnVal = matcher.replaceAll(" ");
		}
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		returnVal = returnVal.replaceAll("\\( ", "(");
		// returnVal = returnVal.replaceAll("\\) ",")");
		// returnVal = returnVal.replaceAll(" \\(",")");
		returnVal = returnVal.replaceAll(" \\)", ")");
		returnVal = returnVal.replaceAll(" \\=", "=");
		returnVal = returnVal.replaceAll("\\= ", "=");

		// System.out.println(returnVal);

		return returnVal;
	}

	public int count_bracket(String s) {
		String strtemp = "";
		int int_bracket = 0;
		while (s.length() > 0) {
			strtemp = s.substring(s.length() - 1);

			if (strtemp.toUpperCase().equals("(".toUpperCase()))
				int_bracket--;
			if (strtemp.toUpperCase().equals(")".toUpperCase()))
				int_bracket++;
			s = s.substring(0, (s.length() - 1) - (0));
		}
		// System.out.println(int_bracket);
		return int_bracket;
	}

	public String add_prefix(String tmpString) {
		if (tmpString.indexOf(" -") == -1 && tmpString.indexOf("- ") == -1
				&& tmpString.indexOf(" - ") == -1
				&& tmpString.indexOf("-") != -1
				&& tmpString.indexOf("\\-") == -1) {
			tmpString = tmpString.replaceAll("-", "@");
		}
		// 洗衣机/ti,ab,cl
		tmpString = tmpString.toLowerCase();

		if (tmpString.indexOf("/ipn") != -1 || tmpString.indexOf("/国际公布") != -1) {// 国际公布
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/ian") != -1
				|| tmpString.indexOf("/国际申请") != -1) { // 分案原申请号
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/dan") != -1
				|| tmpString.indexOf("/分案原申请号") != -1) { // 分案原申请号
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/ipd") != -1
				|| tmpString.indexOf("/颁证日") != -1) { // 颁证日
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/an") != -1
				|| tmpString.indexOf("/申请号") != -1) { // 申请号
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/ad") != -1
				|| tmpString.indexOf("/申请日") != -1) { // 申请日
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/pn") != -1
				|| tmpString.indexOf("/专利号") != -1) { // 专利号
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/pnm") != -1
				|| tmpString.indexOf("/公开（公告）号") != -1) { // 公开（公告）号
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/pd") != -1
				|| tmpString.indexOf("/公开（公告）日") != -1) { // 公开（公告）日
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/ti") != -1
				|| tmpString.indexOf("/名称") != -1) { // 名称
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/ab") != -1
				|| tmpString.indexOf("/摘要") != -1) { // 摘要
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/主分类号") != -1
				|| tmpString.indexOf("主分类号=") != -1
				|| tmpString.indexOf("/pic") != -1
				|| tmpString.indexOf("pic=") != -1
				|| tmpString.indexOf("pic,") != -1
				|| tmpString.indexOf(",pic") != -1) {
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/sic") != -1
				|| tmpString.indexOf("/分类号") != -1) { // 分类号
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/pa") != -1
				|| tmpString.indexOf("/申请（专利权）人") != -1) { // 申请（专利权）人
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/in") != -1
				|| tmpString.indexOf("/发明（设计）人") != -1) { // 发明（设计）人
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/cl") != -1
				|| tmpString.indexOf("/主权项") != -1) { // 主权项
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/ar") != -1
				|| tmpString.indexOf("/地址") != -1) { // 地址
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/agc") != -1
				|| tmpString.indexOf("/专利代理机构") != -1) { // 专利代理机构
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/agt") != -1
				|| tmpString.indexOf("/代理人") != -1) { // 代理人
			tmpString = add_prefix_process(tmpString);
		} else if (tmpString.indexOf("/pr") != -1
				|| tmpString.indexOf("/优先权") != -1) { // 优先权
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/fa") != -1
				|| tmpString.indexOf("/同族专利项") != -1) { // 同族专利项
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/ct") != -1
				|| tmpString.indexOf("/范畴分类") != -1) { // 范畴分类
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/co") != -1
				|| tmpString.indexOf("/国省代码") != -1) { // 国省代码
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/clm") != -1
				|| tmpString.indexOf("/权利要求书") != -1) { // 国省代码
			tmpString = add_prefix_process(tmpString);
			tmpString = ReGetFormatString(tmpString);
		} else if (tmpString.indexOf("/ft") != -1
				|| tmpString.indexOf("/说明书") != -1) { // 权利要求书,说明书,说明书附图,附件+=
			tmpString = add_prefix_process(tmpString);
		} 
		/**
		 * 添加智能检索
		 */
		else if(tmpString.indexOf("/ss") >-1||tmpString.indexOf("/智能检索") >-1){
			tmpString = add_prefix_process(tmpString);
//			tmpString = ReGetFormatString(tmpString);
		}
		
		else if ((!tmpString.trim().equals("or")
				&& !tmpString.trim().equals("and")
				&& !tmpString.trim().equals("not")
				&& !tmpString.trim().equals("to")
				&& !tmpString.trim().equals("adj") && !tmpString.trim().equals(
				"xor"))
				&& ((tmpString.indexOf("pre#") == -1)
						|| (tmpString.indexOf("xor#") == -1) || (tmpString
						.indexOf("equ#") == -1))
				&& (// 以下都是prase或document或date类型的
				(tmpString.indexOf("ipd=") == -1)
						&& (tmpString.indexOf("颁证日=") == -1)
						&& (tmpString.indexOf("ad=") == -1)
						&& (tmpString.indexOf("申请日=") == -1)
						&& (tmpString.indexOf("pd=") == -1)
						&& (tmpString.indexOf("公开（公告）日=") == -1)
						&& (tmpString.indexOf("ti=") == -1)
						&& (tmpString.indexOf("名称=") == -1)
						&& (tmpString.indexOf("ab=") == -1)
						&& (tmpString.indexOf("摘要=") == -1)
						&& (tmpString.indexOf("pa=") == -1)
						&& (tmpString.indexOf("申请（专利权）人=") == -1)
						&& (tmpString.indexOf("in=") == -1)
						&& (tmpString.indexOf("发明（设计）人=") == -1)
						&& (tmpString.indexOf("cl=") == -1)
						&& (tmpString.indexOf("主权项=") == -1)
						&& (tmpString.indexOf("ar=") == -1)
						&& (tmpString.indexOf("地址=") == -1)
						&& (tmpString.indexOf("agt=") == -1)
						&& (tmpString.indexOf("代理人=") == -1)
						&& (tmpString.indexOf("agc=") == -1)
						&& (tmpString.indexOf("专利代理机构=") == -1)
						&& (tmpString.indexOf("clm=") == -1)
						&& (tmpString.indexOf("权利要求书=") == -1)
						&& (tmpString.indexOf("ft=") == -1) && (tmpString
						.indexOf("说明书=") == -1))
				&& ((tmpString.indexOf("pnm=") != -1)
						|| (tmpString.indexOf("公开（公告）号=") != -1)
						|| (tmpString.indexOf("an=") != -1)
						|| (tmpString.indexOf("申请号=") != -1)
						|| (tmpString.indexOf("pn=") != -1)
						|| (tmpString.indexOf("专利号=") != -1)
						|| (tmpString.indexOf("pic=") != -1)
						|| (tmpString.indexOf("主分类号=") != -1)
						|| (tmpString.indexOf("sic=") != -1)
						|| (tmpString.indexOf("分类号=") != -1)
						|| (tmpString.indexOf("dan=") != -1)
						|| (tmpString.indexOf("分案原申请号=") != -1)
						|| (tmpString.indexOf("pr=") != -1)
						|| (tmpString.indexOf("优先权=") != -1)
						|| (tmpString.indexOf("ian=") != -1)
						|| (tmpString.indexOf("国际申请=") != -1)
						|| (tmpString.indexOf("ipn=") != -1)
						|| (tmpString.indexOf("国际公布=") != -1)
						|| (tmpString.indexOf("ct=") != -1)
						|| (tmpString.indexOf("范畴分类=") != -1)
						|| (tmpString.indexOf("co=") != -1) || (tmpString
						.indexOf("国省代码=") != -1))) {
			tmpString = ReGetFormatString(tmpString);
		}
		return tmpString;
	}

	public String add_prefix_process(String tmpString) {
		String tmpString_ori = tmpString;
		/*
		 * (((教育 or 医疗) and (方法 or 技术))/ti,ab,cl or pic=A01K) 取出ti,ab,cl
		 * 
		 * ((计算机 or 电脑)/ft and (控制 or 方法)/ft) and A61K/pic
		 */
		int int_slash_position = tmpString.indexOf("/");
		if (int_slash_position == -1) {
			return tmpString;
		}
		tmpString = tmpString.substring(int_slash_position + 1);
		String s_code = tmpString.split(" ")[0];

		boolean b_break = false;
		for (int i = 0; i < tmpString.length() && !b_break; i++) {
			String currentStr = tmpString.substring(i, i + 1);
			if (currentStr.equals(")") || currentStr.equals(" ")) {
				b_break = true;
				s_code = tmpString.substring(0, i);
			}
		}

		tmpString = tmpString_ori;

		int int_location = tmpString_ori.indexOf("/" + s_code);
		int[] int_arr = new int[int_location];
		int int_bracket = 0;
		while (tmpString.length() > 0) {
			String lString = tmpString
					.substring(int_location - 1, int_location);

			if (lString.equals(")")) {
				int_bracket++;
			}
			if (lString.equals("(")) {
				int_bracket--;
			}
			// ilocation++;
			if (int_bracket == 0) {
				int_arr[int_location - 1] = 0;
			} else {
				int_arr[int_location - 1] = 1;
			}
			int_location--;
			tmpString = tmpString.substring(0, int_location);
		}
		// 从左边起，int_arr数组中第一个为0的那个位置，就是ipn=的位置。

		for (int i = 0; i < int_arr.length; i++) {
			if (int_arr[i] == 0) {
				int_location = i;
				break;
			}
		}

		if (s_code.indexOf(",") > -1) {
			tmpString = tmpString_ori.substring(0, int_location) + s_code
					+ "+=" + tmpString_ori.substring(int_location);
		} else {
			tmpString = tmpString_ori.substring(0, int_location) + s_code + "="
					+ tmpString_ori.substring(int_location);
		}
		tmpString = tmpString.replace("/" + s_code, "");

		// System.out.println(tmpString);

		return tmpString;
	}

	public Object expand(Object array, int newSize) {
		if (array == null) {
			return null;
		}

		Class c = array.getClass();
		if (c.isArray()) {
			int len = Array.getLength(array);
			// if (len >= newSize) {
			// return array;
			// }
			// else
			// {
			Class cc = c.getComponentType();
			newSize = len + 1;
			Object newArray = Array.newInstance(cc, newSize);
			System.arraycopy(array, 0, newArray, 0, len);
			return newArray;
			// }
		} else {
			throw new ClassCastException("need  array");
		}
	}

	public boolean isDigits(String str) {
		if ((str == null) || (str.length() == 0)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public String replaceSpecialString(String s, String s1, String s2) {
		int is = 0;
		String strTmp = "";
		String ts1 = "";

		while (is < s.length()) {
			ts1 = s.substring(is, is + 1);
			is++;

			if (ts1.equals(s1)) {
				strTmp += s2;
			} else {
				strTmp += ts1;
			}
		}
		s = strTmp;
		return s;
	}

	String[] arrContent = null;
	String[] arrCommaContent = null;

	/*********************************
	 * 结束 *****************************************
	 * 
	 * @throws WASException
	 */
	public String preprocess(String s) {
		String src = s;
		try {
			s = s.toLowerCase();
			// ++++++++++++++++++++++把多个连在一起的空格替换成一个空格++++++++++++++++++++++++++++
			/*
			 * Pattern pattern = Pattern.compile("[\\s]+"); Matcher matcher =
			 * pattern.matcher(s);
			 * 
			 * while (matcher.find()) { //System.out.println(matcher.group()); s
			 * = matcher.replaceAll(" "); }
			 */
			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// 正则表达式，把多个空格转成一个空格 C#
			// s = Regex.Replace(s, " +", " ");

			s = s.replace(" =", "=");
			s = s.replace("= ", "=");
			s = s.replace("( ", "(");
			s = s.replace(" )", ")");

			s = s.replace(" - ", " not ");
			s = s.replace(" + ", " or ");
			s = s.replace(" * ", " and ");

			s = s.replace("？", "?");
			s = s.replace("％", "%");
			s = s.replace("（", "(");
			s = s.replace("）", ")");
			s = s.replace("＜", "<");
			s = s.replace("＞", ">");
			s = s.replace("＝", "=");
			s = s.replace("′", "'");
			s = s.replace("，", ",");

			if (s.indexOf(" -") == -1 && s.indexOf("- ") == -1
					&& s.indexOf(" - ") == -1 && s.indexOf("-") != -1) {
				// s=s.replaceAll("-","@");
			}
			// s = s.replace("‘’", "'");

			s = s.replace("申请(专利)号", "申请号");
			s = s.replace("公开(公告)号", "公开（公告）号");
			s = s.replace("公开(公告)日", "公开（公告）日");
			s = s.replace("申请(专利权)人", "申请（专利权）人");
			s = s.replace("发明(设计)人", "发明（设计）人");

			int left_bracket = 0;
			int right_bracket = 0;

			// int int_comma = 0;
			String strtemp = "";
			String s_ori = s;
			while (s.length() > 0) {
				strtemp = s.substring(s.length() - 1);

				if (strtemp.toUpperCase().equals("(".toUpperCase()))
					left_bracket++;
				if (strtemp.toUpperCase().equals(")".toUpperCase()))
					right_bracket++;
				/*
				 * if (strtemp.toUpperCase().equals("'".toUpperCase()))
				 * int_comma++;
				 */

				s = s.substring(0, (s.length() - 1) - (0));
			}
			if (left_bracket != right_bracket) {
				// System.Console.Out.WriteLine("左右括号不匹配！");
				// MessageBox.Show("左右括号不匹配！");
				// return "";
				// System.out.println("左右括号不匹配！");
				throw new Exception("检索表达式左右括号不匹配!");
				// return "";
			}/*
			 * if (int_comma % 2 == 0) { //MessageBox.Show("偶数");
			 * //System.Console.Out.WriteLine("左右括号不匹配！"); } else {
			 * //MessageBox.Show("引号不对称！"); //return "";
			 * //System.Console.Out.WriteLine("引号不对称！");
			 * System.out.println("引号不对称！"); }
			 */

			s = s_ori;// 重要！！

			// s=s.replaceAll("equ#","equ/");
			// s=s.replaceAll("xor#","xor/");
			// s=s.replaceAll("pre#","pre/");

			// '阿 以'/ti
			int int_comma = 0;
			boolean b_comma = false;
			String stemp = "";
			s_ori = s;
			while (s.length() > 0) {
				stemp = s.substring(s.length() - 1);

				if (stemp.toUpperCase().equals("'".toUpperCase())) {
					int_comma++;
					b_comma = true;
				}

				s = s.substring(0, s.length() - 1);
			}
			s = s_ori;

			// System.out.println(s);
			// s="x 'x x' x 'x x x' xx";
			if (int_comma % 2 == 0 && b_comma == true)// 出现过单引号，并且单引号的成对
			{
				arrCommaContent = new String[int_comma / 2];

				Pattern pattern = Pattern.compile("'[^']+'");
				Matcher matcher = pattern.matcher(s);
				// 名称,摘要,主权项+=(对讲 and 楼宇 or 对讲机　or 对讲电话) or 名称=(对讲%) or
				// 主分类号=(H04Q% or '14-03%' or '10-06%' or '10-05%') or
				// 主分类号=H04Q5/2
				ArrayList<String> alTemp = new ArrayList<String>();
				String tmpString = null;
				int pos1 = 0;
				int pos2 = 0;
				int i = 0;
				while (matcher.find()) {// 取出内容
					tmpString = matcher.group();
					pos2 = matcher.start(0);
					// pos2=s.indexOf(tmpString);

					alTemp.add(trans(s.substring(pos1, pos2)));
					// alTemp.add(tmpString);
					arrCommaContent[i] = tmpString;
					alTemp.add("※※" + i + "※※");
					pos1 = pos2 + tmpString.length();
					i++;
				}
				if (pos1 < s.length()) {
					alTemp.add(trans(s.substring(pos1)));
				}
				// System.out.println(alTemp.size());
				s = "";
				for (int j = 0; j < alTemp.size(); j++) {
					s += alTemp.get(j);
				}
			} else {
				s = trans(s);
			}
			// System.out.println(s);

			s = s.trim();

			s = InFormatString(s);
			// s = InFormatString_left(s);
			// System.out.println(s);
			s = ReplaceAliaseWithName(s);
			// System.out.println("n   "+s);

			s = s.trim();

			// s=s.replaceAll("※", "/");
			// s=s.replaceAll("#"," ");

			if (arrCommaContent != null && arrCommaContent.length > 0) {
				for (int i = 0; i < arrCommaContent.length; i++) {
					s = s.replace("※※" + i + "※※", arrCommaContent[i]);
				}
			}

			s = s.replaceAll("and#", "and/");
			s = s.replaceAll("not#", "not/");
			s = s.replaceAll("equ#", "equ/");
			s = s.replaceAll("xor#", "xor/");
			s = s.replaceAll("pre#", "pre/");

			// s=s.replace("|","\\/");
			s = s.replace("|", "/");
			s = s.replaceAll("!c!", "\\\\/");
			s = s.replaceAll("@", "\\\\-");
			/*
			 * System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
			 * ); System.out.println(s);System.out.println(
			 * "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			 */
			// pattern = Pattern.compile("[\\\\]{0,}/");
			Pattern pattern = Pattern.compile("[\\\\]{1,}/");
			Matcher matcher = pattern.matcher(s);

			if (matcher.find()) {
				// System.out.println(matcher.group());
				s = s.replaceAll(matcher.group(), "\\/");
			}

			// System.out.println(s);

			return s;
		} catch (Exception wasexception) {
			// WASException wase = new WASException("括号匹配......");
			// session.setAttribute("was_exception",wase);
			// //将新的异常对象保存到session中，以便在报错页error.jsp中获得
			return src;
		}
	}

	private  String trans(String s) {
		s = s.replaceAll("/ian", "#ian");
		s = s.replaceAll("/国际申请", "#国际申请");
		s = s.replaceAll("/ipn", "#ipn");
		s = s.replaceAll("/国际公布", "#国际公布");
		s = s.replaceAll("/ipd", "#ipd");
		s = s.replaceAll("/颁证日", "#颁证日");
		s = s.replaceAll("/dan", "#dan");
		s = s.replaceAll("/分案原申请号", "#分案原申请号");
		s = s.replaceAll("/an", "#an");
		s = s.replaceAll("/申请号", "#申请号");
		s = s.replaceAll("/ad", "#ad");
		s = s.replaceAll("/申请日", "#申请日");
		s = s.replaceAll("/pnm", "#pnm");
		s = s.replaceAll("/pn", "#pn");
		s = s.replaceAll("/专利号", "#专利号");
		s = s.replaceAll("/公开（公告）号", "#公开（公告）号");
		s = s.replaceAll("/pd", "#pd");
		s = s.replaceAll("/公开（公告）日", "#公开（公告）日");
		s = s.replaceAll("/ti", "#ti");
		s = s.replaceAll("/名称", "#名称");
		s = s.replaceAll("/ab", "#ab");
		s = s.replaceAll("/摘要", "#摘要");
		s = s.replaceAll("/pic", "#pic");
		s = s.replaceAll("/主分类号", "#主分类号");
		s = s.replaceAll("/sic", "#sic");
		s = s.replaceAll("/分类号", "#分类号");
		s = s.replaceAll("/pa", "#pa");
		s = s.replaceAll("/申请（专利权）人", "#申请（专利权）人");
		s = s.replaceAll("/in", "#in");
		s = s.replaceAll("/发明（设计）人", "#发明（设计）人");
		s = s.replaceAll("/cl", "#cl");
		s = s.replaceAll("/主权项", "#主权项");
		s = s.replaceAll("/ar", "#ar");
		s = s.replaceAll("/地址", "#地址");
		s = s.replaceAll("/agc", "#agc");
		s = s.replaceAll("/专利代理机构", "#专利代理机构");
		s = s.replaceAll("/agt", "#agt");
		s = s.replaceAll("/代理人", "#代理人");
		s = s.replaceAll("/pr", "#pr");
		s = s.replaceAll("/优先权", "#优先权");
		s = s.replaceAll("/fa", "#fa");
		s = s.replaceAll("/同族专利项", "#同族专利项");
		s = s.replaceAll("/ct", "#ct");
		s = s.replaceAll("/范畴分类", "#范畴分类");
		s = s.replaceAll("/co", "#co");
		s = s.replaceAll("/国省代码", "#国省代码");
		s = s.replaceAll("/clm", "#clm");
		s = s.replaceAll("/权利要求书", "#权利要求书");
		s = s.replaceAll("/ft", "#ft");
		s = s.replaceAll("/说明书", "#说明书");
		
		/**
		 * 添加智能检索
		 */
		s = s.replaceAll("/ss", "#ss");
		s = s.replaceAll("/智能检索", "#ss");
		s = s.replaceAll("equ/", "equ#");
		s = s.replaceAll("xor/", "xor#");
		s = s.replaceAll("pre/", "pre#");
		s = s.replaceAll("and/", "and#");
		s = s.replaceAll("not/", "not#");

		s = s.replaceAll("/", "\\\\|");
		s = s.replaceAll("#ss", "/ss");
		s = s.replaceAll("#智能检索", "/ss");
		s = s.replaceAll("#ian", "/ian");
		s = s.replaceAll("#国际申请", "/国际申请");
		s = s.replaceAll("#ipn", "/ipn");
		s = s.replaceAll("#国际公布", "/国际公布");
		s = s.replaceAll("#ipd", "/ipd");
		s = s.replaceAll("#颁证日", "/颁证日");
		s = s.replaceAll("#dan", "/dan");
		s = s.replaceAll("#分案原申请号", "/分案原申请号");
		s = s.replaceAll("#an", "/an");
		s = s.replaceAll("#申请号", "/申请号");
		s = s.replaceAll("#ad", "/ad");
		s = s.replaceAll("#申请日", "/申请日");
		s = s.replaceAll("#pn", "/pn");
		s = s.replaceAll("#专利号", "/专利号");
		s = s.replaceAll("#pnm", "/pnm");
		s = s.replaceAll("#公开（公告）号", "/公开（公告）号");
		s = s.replaceAll("#pd", "/pd");
		s = s.replaceAll("#公开（公告）日", "/公开（公告）日");
		s = s.replaceAll("#ti", "/ti");
		s = s.replaceAll("#名称", "/名称");
		s = s.replaceAll("#ab", "/ab");
		s = s.replaceAll("#摘要", "/摘要");
		s = s.replaceAll("#pic", "/pic");
		s = s.replaceAll("#主分类号", "/主分类号");
		s = s.replaceAll("#sic", "/sic");
		s = s.replaceAll("#分类号", "/分类号");
		s = s.replaceAll("#pa", "/pa");
		s = s.replaceAll("#申请（专利权）人", "/申请（专利权）人");
		s = s.replaceAll("#in", "/in");
		s = s.replaceAll("#发明（设计）人", "/发明（设计）人");
		s = s.replaceAll("#cl", "/cl");
		s = s.replaceAll("#主权项", "/主权项");
		s = s.replaceAll("#ar", "/ar");
		s = s.replaceAll("#地址", "/地址");
		s = s.replaceAll("#agc", "/agc");
		s = s.replaceAll("#专利代理机构", "/专利代理机构");
		s = s.replaceAll("#agt", "/agt");
		s = s.replaceAll("#代理人", "/代理人");
		s = s.replaceAll("#pr", "/pr");
		s = s.replaceAll("#优先权", "/优先权");
		s = s.replaceAll("#fa", "/fa");
		s = s.replaceAll("#同族专利项", "/同族专利项");
		s = s.replaceAll("#ct", "/ct");
		s = s.replaceAll("#范畴分类", "/范畴分类");
		s = s.replaceAll("#co", "/co");
		s = s.replaceAll("#国省代码", "/国省代码");
		s = s.replaceAll("#clm", "/clm");
		s = s.replaceAll("#权利要求书", "/权利要求书");
		s = s.replaceAll("#ft", "/ft");
		s = s.replaceAll("#说明书", "/说明书");
		
		// s=s.trim();
		s = s.replaceAll("-", "\\-");

		return s;
	}

	public void main1(String[] args) {
		try {
//			System.out.println(GetSearchFormat.preprocess("计算机/SS"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		/*
		 * String s1 = ""; int i = 0; boolean bf = false; String strTmp = "";
		 * 
		 * while(i < s.length()) { s1 = s.substring(i,i+1); i++;
		 * if(s1.equals("/")) { strTmp += s1; bf = true; continue; } if(bf) { bf
		 * = false; String regEx = "[0-9%]+"; Pattern p =
		 * Pattern.compile(regEx); Matcher m = p.matcher(s1); if(m.matches()) {
		 * strTmp = strTmp.substring(0,strTmp.length() - 1) + "!c!" + s1; } else
		 * strTmp += s1; } else strTmp += s1; } s = strTmp;
		 */
		s = "((生物 or 医药) and (计算机 or 电脑) and (控制 or 方法))/an";
		s = "((生物 or 医药) and (计算机 or 电脑) and (控制 or 方法))/ti";
		s = "((生物 or 医药) and (计算机 or 电脑) and (控制 or 方法))";
		s = "ipn=((生物 or 医药) and (计算机 or 电脑) and (控制 or 方法))";
		s = "(计算机 or 电脑)/ft and (控制 or 方法)/ft";
		s = "((计算机 or 电脑) and (控制 or 方法))/ft";
		// s="(计算机 or 电脑)/an and (控制 or 方法)/ft";
		s = "(计算机 and pn=(控制 or 方法) and 医药) or (微波 or 高频)/an";
		// s="((计算机 or 电脑) and (控制 or 方法))/ft";
		s = "((计算机 or 电脑)/ft and (控制 or 方法)/ft) and A61K/pic";
		// s="(计算机 or 电脑)/ft and A61K/pic and (控制 or 方法)/ft";
		s = "((微波 or 高频) and (蒸汽 or 蒸气) and (壳 or 盒 or 腔 or 箱)) and (2002.10 to 2006.06)/pd";
		// s="(ft=(计算机 or 电脑) and (控制 or 方法)/ft) and A61K/pic";
		// s="A61K/pic and (ft=(计算机 or 电脑) and (控制 or 方法)/ft)";
		s = "((电脑)/ti) and (ti=(计算机))";
		s = "(ti=(数字?)) not (ti=数字? not ti=数字)";
		s = "(ti=(数字 or 数字?)) and (an=(版权 or 权利 or 权限 or 著作权 or 知识产权))";
		// s="(ti=(计算机)) and ((电脑)/ti)";
		s = "an=( three adj phase+ or 3 adj phase or triphase ) and separator and sludge";
		s = "( 厨% and %柜 ) and %拉%/cl";
		s = "( 轮子 or 轮组 or 车轮 or 轮座 ) and ( 拆下 or 快拆 or 拆卸 or 拆装 )";
		// s="(计算机 or 电脑)/ipn and ti=(控制 or 方法)";
		// s="((版权 or 著作权/ti) and (控制 or 方法))";
		s = "汽车";
		s = "((energy/ti) and ((bellows/ti) and (ti=(accumulator))) ) AND ((bellows/ti) and (ti=(accumulator)) )";
		// s="((energy/ipn) and ((bellows/ti) and (ti=(accumulator)))) AND (bellows/ti and (ti=(accumulator)))";
		s = "petrophysic/an or petrophysics or petrophysical";
		// s="( ( magnetic/ab adj resonance/ab or nmr/ab ) and logging/ab adj tool/ab and (petrophysic or petrophysics or petrophysical )/ab)";

		// s="汽车/名称,摘要,主权项";
		// s="汽车/名称";
		// s="(computer or function) and energy/ipn or ti=aaaa";
		s = "(b/pic and cn2005/an) or ((((computer? or function) and (energy)/an and ti=accumulator) and (a xor b)) or (x pre/10 t)) and bellows/an";
		// 上面的表达式分裂成：申请号=cn2005%) or ((((computer? or function%)
		// ((((computer? or function%)中既没有/也没有=
		// 是否可以把规律总结为遇到(后，第一个空格处就截断

		s = "((((computer? or function) and (energy)/an and ti=accumulator) and (a xor b)) or (x pre/10 t)) and bellows/an";
		s = "(b/pic and cn2005/an) or (((computer and (energy)/an and ti=accumulator) and (a xor b)) or (x pre/10 t)) and bellows/an";
		// s="((((computer or function) and (energy)/ti and ti=accumulator) and ti=(a xor b)) or (x pre/10 t)/ab) and bellows/ti";
		// s="((((computer or function) and (energy)/ti and ti=accumulator) and ti=(a and b)) or (x and t)/ab) and bellows/ti";
		s = "(acc pre/10 eng)/ar or (com xor func)/ab";
		s = "fa=(computer or function) and energy/ti and ti=accumulator";
		s = "(电梯 or 升降机) and 滑轮";
		s = "(电梯% or 升降机%) and 滑轮%";
		s = "A01k/00/pic";
		s = "(S II:KK)/PA";

		s = "'阿 以'/ti";
		s = "上海专利/AGC or ft='func com' or (B/PIC and 日东电工/PA) or '阿 以'/ti";

		s = "pon1-17";
		s = "1-naphthol and 2-naphthol";
		s = "CL=(Pb or Lead or 铅) and CL=(Zr or zirconium or 锆) and CL=(Ti or 钛 or titanium) and AD=19850820 to 20050819";

		// s="ft=((Ca and 2) and (BO and 3) and Cl)";
		s = "(((两 or 双) and (麦克 or  传感器) and 定位)/AB or ((两 or 双) and (麦克 or  传感器) and 定位)/TI) and (1991.1 to 2005.7)/PD";
		// s="((两 or 双) and (麦克 or  传感器) and 定位)/AB or ((两 or 双) and (麦克 or  传感器) and 定位)/TI";
		s = "((ab=(PU) or ab=(聚氨酯)) or ab=(聚丙烯酸)) or ab=(PA)";
		s = "((an=(PU) or 聚氨酯 or 锂离子) or ab=(聚丙烯酸)) or ab=(PA)";
		// s="((H01M2/14/PIC or H01M2/16/PIC or H01M2/18/PIC) and(锂离子/AB and 电池/AB and 隔膜/AB)) or ((H01M2/14/PIC or H01M2/16/PIC or H01M2/18/PIC) and (锂离子/TI and 电池/TI and 隔膜/TI))";
		s = "(g09b19/00 or g09b29/00)/sic";// 这个好办，把/00换成|00
		s = "((ad>2000.1 and pd<2005.6) or (G09B19/00 or G09B23/02)/sic) and (教育 and 方法)/ipn";
		// s="((B/PIC and 日东电工/PA) or (D/PIC and 日东电工/PA)) not (上海专利/AGC or 柳沈/AGC or 中科/AGC or 香港/AGC or 中国专利代理有限公司/AGC or 永新/AGC)";
		// s="((sic=(g01c21/ or g08g1/09 or g09b29/00 or g09b29/10 or g01s5/08 to 5/14 or g08g1/096% or g08g1/097% or g08g1/12% or g08g1/13)) or (((sic=(h04b7/26 or h04q7/20 to 7/38) or sic=(g06f15% or g06f17%))) and (ti,cl,ab=(车辆% or 小汽车% or 客车% or 汽车% or 车% or 交通工具% or 机动车%)))) and (ti,cl,ab=(天气% or 气候% or 气象% or 新闻% or 消息%))";
		// s="((B/PIC and 日东电工/PA) or (D/PIC and 日东电工/PA))";
		s = "((((a or b) and (t or i))/ti or (c and d)/ft) and (m or n)/ti)";
		// s="(((a or b) and (t or i))/ti or (c and d)/ft) and (m or n)/ti";
		// s="(a or (x and y)/an or c or b) and m and n";
		s = "(('func com' and CN20041001)/an or 教育 or 方法) and (1991.1 to 2005.7)/PD";
		// s="( ( B/PIC and 日东电工/PA )  or  ( D/PIC and 日东电工/PA  ) )  not  (上海专利/AGC or 柳沈/AGC or 中科/AGC or 香港/AGC or 中国专利代理有限公司/AGC or 永新/AGC  )";
		// s="((B/PIC and 日东电工/PA) or (D/PIC and 日东电工/PA)) not (上海专利/AGC or 柳沈/AGC or 中科/AGC or 香港/AGC or 中国专利代理有限公司/AGC or 永新/AGC)";

		// s="((两 or 双) and an=(麦克 or  传感器) and 定位)  or m or n";
		// s="(b/pic and cn2005/an) or ((((computer? or function) and (energy)/an and ti=accumulator) and (a xor b)) or (x pre/10 t)) and bellows/an";
		// s="(((('com fun' or energy) and (bellows or 'accum petro'))/an or ('控制' and 方法)/ft) and (生物 or  医药)/ti)";
		// s="上海专利/AGC or ft='func com' or (B/PIC and 日东电工/PA) or '阿 以'/ti";
		// s="'com or func or energy or bellows'/pic";
		// s="((((computer? or function) and (energy)/an and ti=accumulator) and (a xor b)) or (x pre/10 t)) and bellows/an";
		// s="'眼镜 透镜'/ab";

		s = "(名称=securing) and (主分类号=('g06f11' or 'g01r31/28' or 'g06f12/14' or 'g06f12/16') or ((microcomputer or computer or server)/cl and (maintenance or protect% or defend or guard or maintain or repair)))";
		// s="((激光)/ti) and (主分类号=('b24b9/14' or 'b29l11/00' or 'c03b11/08' or 'c03b37' or 'c03b23/22' or 'g01m11%' or 'g02b%' or 'g02c%' or 'g02f%' or 'g01b9%' or 'g01b11%' or 'g01c3%' or 'g01j%' or 'g01n21%' or 'a61n5/06' or 'a61n5/073' or 'a61n5/08' or 'a61f9/02' or 'a61l12%' or 'b29d11/00' or 'b29d12/02' or 'g08c19/36' or 'g09b23/22' or 'b24b49/12' or 'b60r1%' or 'b64d45/08' or 'b24b13%' not 'g02b5/08' not 'g02b7/182') or (分类号='g09g%' and 名称,摘要,主权项+=液晶) or (名称=(眼镜 or 透镜 or 棱镜 or 显微镜 or 望远镜 or 放大镜 or 液晶) not 名称=(镜子 or 反光镜 or 哈哈镜 or 相机 or 投影)))";
		// s="主分类号=('B24B9/14') or (分类号='G09G%' and 名称,摘要,主权项+=液晶) or (名称=(眼镜 or 透镜) not 名称=(镜子 or 反光镜))";
		// s="WO2003/009704/IPN";
		// s="名称=计算机 and 电脑";
		// s="名称= ( 计算机 and 电脑 ) ";
		// s="15/CO";
		// s="(电梯 or 升降机) and 滑轮";
		// s="名称='Lavatory system'";

		// s="线 or 摘要=纱";
		// s="摘要=纱 or 线";
		// s="10-11/pic";
		// s="AB=(聚酯*膜)";
		// s="(ti=(电脑)) and (an=(cn%2006))";
		// s="主分类号=('G06F11%' or 'G01R31/28' or 'G06F12/14' or 'G06F12/16') or 名称=((计算机 or 微机 or 电脑 or PC or 服务器) and (维护 or 保护 or 防护 or 保养 or 修理))";
		// s="'WO2001/018132  英  2001.3.15'/IPN";
		s = "'pon1-17'";
		s = "主分类号=('g06f11' or 'g01r31/28' or 'g06f12/14' or 'g06f12/16')";
		s = "((名称=(computer)))  not (((摘要=(system))) and (名称=vehicle))";
		s = "an=(%)";
		s = "优先权=(1996.11.5 US 60/030,213)";
		s = "(计算机 or 电脑)/ft and (控制 or 方法)/ft";
		s = "国际公布,颁证日,摘要=1996.3.1";
		s = "主分类号=('E04B5/36%' or 'E04C2/36%' or 'E04F15/02%' or 'E04G15/06%')";
		s = "主分类号=('G06F11%' or (G01R31/28) or (G06F12/14) or 'G06F12/16')";
		s = "主分类号=(11-)";
		s = "主分类号=(11-%) and 主分类号=(30-)";
		s = "E04B5/36/pic";
		s = "pic=E04B5/36";
		s = "A01k/00/pic";
		// s="主分类号=(11- or 30-)";
		// s="名称=(牛奶-) and 主分类号=(11-%) and 主分类号=(30-)";
		s = "洗衣机/ti,ab,cl";
		s = "(((教育 or 医疗) and (方法 or 技术))/ti,ab,cl or pic=A01K)";
		s = "1994.9.5/ipd";
		s = "2002/ad";
		s = "((计算机 or 电脑)/名称,摘要,主权项 and (控制 or 方法)/ti,ab,cl) and A61K/pic";
		// s="((计算机 or 电脑)/名称,摘要,主权项 and (控制 or 方法)/名称,摘要,主权项) and A61K/pic";
		s = "(名称=securing) and (主分类号=('g06f11' or 'g01r31/28' or 'g06f12/14' or 'g06f12/16') or 名称=((microcomputer or computer or server) and (maintenance or protect% or defend or guard or maintain or repair)))";
		// System.out.println(s.indexOf("\\"));
		// s="主分类号=((G01R31/28) or (G06F12/14) or 'G06F12/16')";
		s = "1994.12.24/ipd";
		s = "1994.12.24/颁证日";
		s = "ipd=20011226";
		s = "20011226/ipd";
		s = "主分类号=(a23l1\\/30%)";
		s = "((H04N13/00 or H04N15/00)/PIC) or (((H04N13/02)/PIC) and 立体电视/AB) or (((H04N13/04)/PIC) and 立体电视/AB)";
		// s="(主分类号=(h04n13\\/00% or h04n15\\/00%)) or ((主分类号=(h04n13\\/02%)) and 摘要=立体电视) or ((主分类号=(h04n13\\/04%)) and 摘要=立体电视)";

		// s="(SIC=(B65D83/12 or G06K13/12 or G06Q40% or G07D1/% or G07D3/% or G07D5/% or G07D7/% or G07D9/% or G07D11/00 or G07D13/00 or G07F1/% or G07F3/02 or G07F3/04 or G07F9/% or G07F19/00 or G07G1/% or G07G5/00) and PD=(20070101 to 20071231)) or (SIC=(B41J11/% or B41J13/% or B41J15/% or B41J17/% or B42D9/04 or B42D15/10 or B42D19/00 or B65B27/08 or B65H% or G06F% or G06K% or G06M% or G06T1/% or G06T7/% or G09G1/% or G09G5/% or G11B5/80 or G11B19/% or G11B20/% or H04L%) and TI,AB,CL+=(银行 or 金融 or 通货 or 货币 or 现金 or 现钞 or 钞票 or 纸币 or 硬币 or 存折 or 出纳员 or 支票 or 凭单 or 单据 or 单证 or 证券) and TI,AB,CL+=((支付 or 交易 or 窗口 or 卡 or 顾客 or 客户 or 存入 or 收款 or 储蓄 or 取款 or 提款 or 取钱 or 存款 or 存钱 or 存取款 or 印鉴 or 印章 or 印影 or 自动存取款机 or ATM or 自动取款机 or 自动出纳机) or (印影 or 余额 or 余数 or 结余 or 余款 or 账户 or 科目 or 项目 or 调换 or 替换 or 移换 or 转账 or 汇款 or 汇兑 or 汇票 or 汇率 or 兑换率 or 翻页 or 分类 or 整理 or 金钟 or 分别 or 区分 or 选别 or 判别 or 识别 or 鉴别 or 检测 or 计数 or 反转 or 逆转 or 倒转 or 施封 or 封带 or 纸条) or (卡 and (现款 or 现金 or 现钞 or 贷款 or 借款 or 代码 or 代号 or 密码)) or ((收据 or 收票 or 收条or 发票) and (印刷纸 or 打印纸))) and PD=(20070101 to 20071231))";
		// s="an=(CN2005 or CN2006100)";
		// s="PCT/GB95/02362/IAN";
		// s="名称,摘要,主权项+=(固井 and (水泥 and 材料))";
		// s="((名称,摘要,主权项+=(对讲 and (装置 or 设备 or 控制机 or 门口机 or 楼宇) or 对讲机　or 对讲电话) or 名称=(对讲%)) and 主分类号=(H04Q% or H04N% or H04M% or H04B% or G08B% or E06B% or '14-03%' or '10-06%' or '10-05%')) or 主分类号=H04Q5/2";
		// s="主分类号=H04Q5/2";
		s = "名称=('gallium arsenide' or 'gallium arsenic' or 'GaAs') or (摘要,主权项+=('gallium arsenide' or 'gallium arsenic' or 'GaAs') and 分类号=(C30B% or H01L%)) or 分类号=C30B29/42";
		s = "主分类号=c01b";
		s = "((亚油酸 or 亚麻仁油酸 or 罂酸 or 亚麻酸 or 亚油烯酸 or 次亚麻仁油酸 or 次亚麻油酸 or 巴豆酸 or 十四酸 or 肉豆蔻酸 or 十四碳烯酸 or 棕闾酸 or 软脂酸 or 棕榈酸 or 十六酸 or 软质酸 or 鳖酸 or 棕榈油酸 or 油酸 or 十八烯酸 or 硬脂酸 or 十八酸 or 花生酸 or 二十碳烯酸 or 反油酸 or 异油酸 or 烯酸 or 芥酸 or  瓢儿菜油酸  or 神经酸 or 十八碳四烯酸 or 花生四烯酸 or 花生油烯酸 or 二十碳五烯酸 or 鲽鱼酸 or 二十二碳六烯酸 or 不饱和脂肪酸 or (不饱和 AND 脂肪酸))/TI OR (亚油酸 or 亚麻仁油酸 or 罂酸 or 亚麻酸 or 亚油烯酸 or 次亚麻仁油酸 or 次亚麻油酸 or 巴豆酸 or 十四酸 or 肉豆蔻酸 or 十四碳烯酸 or 棕闾酸 or 软脂酸 or 棕榈酸 or 十六酸 or 软质酸 or 鳖酸 or 棕榈油酸 or 油酸 or 十八烯酸 or 硬脂酸 or 十八酸 or 花生酸 or 二十碳烯酸 or 反油酸 or 异油酸 or 烯酸 or 芥酸 or  瓢儿菜油酸  or 神经酸 or 十八碳四烯酸 or 花生四烯酸 or 花生油 烯酸 or 二十碳五烯酸 or 鲽鱼酸 or 二十二碳六烯酸 or 不饱和脂肪酸 or (不饱和 AND 脂肪酸))/AB OR (亚油酸 or 亚麻仁油酸 or 罂酸 or 亚麻酸 or 亚油烯酸 or 次亚麻仁油酸 or 次亚麻油酸 or 巴豆酸 or 十四酸 or 肉豆蔻酸 or 十四碳烯酸 or 棕闾酸 or 软脂酸 or 棕榈酸 or 十六酸 or 软质酸 or 鳖酸 or 棕榈油酸 or 油酸 or 十八烯酸 or 硬脂酸 or 十八酸 or 花生酸 or 二十碳烯酸 or 反油酸 or 异油酸 or 烯酸 or 芥酸 or  瓢儿菜油酸  or 神经酸 or 十八碳四烯酸 or 花生四烯酸 or 花生油烯酸 or 二十碳五烯酸 or 鲽鱼酸 or 二十二碳六烯酸 or 不饱和脂肪酸 or (不饱和 AND 脂肪酸))/CLM) AND ((化妆 or 外用 or 经皮 or 经过皮肤 or 皮肤 or 肌肤 or 发 or 头发 or 毛发 or 毛 or 洗脸 or 洗面 or 清洗 or (洗净 AND (身体< /SPAN> or 身 or 体)))/TI OR (化妆 or 外用 or 经皮 or 经过皮肤 or 皮肤 or 肌肤 or 发 or 头发 or 毛发 or 毛 or 洗脸 or 洗面 or 清洗 or (洗净 AND (身体 or 身 or 体)))/AB OR (化妆 or 外用 or 经皮 or 经过皮肤 or 皮肤 or 肌肤 or 发 or 头发 or 毛发 or 毛 or 洗脸 or 洗面 or 清洗 or (洗净 AND (身体 or 身 or 体)))/CLM)";
		s = "(主分类号=(H01G4/12) or 名称= (瓷 and 电容器) or (摘要,主权项+=(瓷 and 电容器) and 主分类号=(H01G%)))  or (名称,摘要,主权项+=(((温补 or 温度补偿) and (晶振 or 晶体振荡器) and 芯片) or 'TCXO') and 主分类号=(H03%)) or ((摘要,主权项+=((制冷 or 致冷) and 半导体) and 主分类号=(H01L%)) or (名称=(半导体 and (器件 or 容器 or 设备 or 装置 or 仪器)) and 主分类号=(F25B%)) or 名称=(半导体 and (制冷 or 致冷) and (器件 or 容器 or 设备 or 装置 or 仪器))) or ((主分类号=(H01P7/10) or 名称=(介质 and (谐振 and (器 or 装置))) or (摘要,主权项+=(介质 and (谐振器 or 谐振装置)) and 主分类号=(H01P%))) or ((名称,摘要,主权项+=(介质 and 滤波 and (器 or 装置)) and 主分类号=(H01P% or H03H%)) or 名称=(介质 and 滤波 and (器 or 装置))) or ((摘要,主权项+=(介质 and 振荡器 and 稳频) and 主分类号=(H03B% or H03L% or H01P%)) or 名称=(介质 and 振荡器)))";
		s = "((((分类号=(B60K1/04 or B60L11/18)) and (摘要=(电池) or 权利要求书=(电池)) and (摘要=(更换 or 交换 or 替换 or 拆 or 卸 or 安装 or 搭载 or 装配 or 装设 or 配置 or 配设 or 装载 or 固定 or 支承 or 保持 or 搬入 or 运入 or 载入 or 搬出 or 运出 or 载出 or 运载 or 搬运) or 权利要求书=(更换 or 交换 or 替换 or 拆 or 卸 or 安装 or 搭载 or 装配 or 装设 or 配置 or 配设 or 装载 or 固定 or 支承 or 保持 or 搬入 or 运入 or 载入 or 搬出 or 运出 or 载出 or 运载 or 搬运))) or ((分类号=(H01M2/10)) and ((分类号=(B60K1/04 or B60L11/18)) or ((分类号=(H01M8/?)) and (摘要=(车) or 权利要求书=(车))) or (摘要=(燃料 and 电池 and 车) or 权利要求书=(燃料 and 电池 and 车)) or (摘要=((电气 or 电力 or 电动) and 车) or 权利要求书=((电气 or 电力 or 电动) and 车)) or (分类号=(B60W? or B60K6/04 or B60L11/14 or B60K17/04 or B60K17/356 or F02D29/02 or F02D29/06)) or (摘要=(混合 and 车) or 权利要求书=(混合 and 车)))) or ((分类号=(H01M8/?)) and (摘要=(车) or 权利要求书=(车)) and (摘要=(电池) or 权利要求书=(电池)) and (摘要=(更换 or 交换 or 替换 or 拆 or 卸 or 安装 or 搭载 or 装配 or 装设 or 配置 or 配设 or 装载 or 固定 or 支承 or 保持 or 搬入 or 运入 or 载入 or 搬出 or 运出 or 载出 or 运载 or 搬运) or 权利要求书=(更换 or 交换 or 替换 or 拆 or 卸 or 安装 or 搭载 or 装配 or 装设 or 配置 or 配设 or 装载 or 固定 or 支承 or 保持 or 搬入 or 运入 or 载入 or 搬出 or 运出 or 载出 or 运载 or 搬运))) or ((分类号=(B60W? or B60K6/04 or B60L11/14 or B60K17/04 or B60K17/356 or F02D29/02 or F02D29/06)) and (摘要=(电池) or 权利要求书=(电池)) and (摘要=(更换 or 交换 or 替换 or 拆 or 卸 or 安装 or 搭载 or 装配 or 装设 or 配置 or 配设 or 装载 or 固定 or 支承 or 保持 or 搬入 or 运入 or 载入 or 搬出 or 运出 or 载出 or 运载 or 搬运) or 权利要求书=(更换 or 交换 or 替换 or 拆 or 卸 or 安装 or 搭载 or 装配 or 装设 or 配置 or 配设 or 装载 or 固定 or 支承 or 保持 or 搬入 or 运入 or 载入 or 搬出 or 运出 or 载出 or 运载 or 搬运)))) and (申请日=(19880501 to 20081020))) not (申请（专利权）人=(本田技研工业株式会社 or 住友电装株式会社 or 住友电气工业株式会社 or 雅马哈发动机株式会社or 丰田自动车株式会社 or 三菱扶桑卡客车株式会社 or 扶桑工程公司 or 丰田自动车株式会社or 安普泰科电子有限公司 or 松下电器产业株式会社 or 株式会社丰田自动织机 or 铃木株式会社 or 精工爱普生株式会社 or 株式会社东京研发股份有限公司 or 日野自动车工业株式会社 or 日本电池株式会社 or 三洋电机株式会社 or 日产自动车株式会社 or 矢崎总业株式会社 or 丰田自动车株式会社 or 株式会社东芝 or 日本电气株式会社 or 三洋电机株式会社 or 日立建机株式会社 or YKK株式会社 or 本田技研工业株式会社 or 株式会社NTT都科摩 or 新神户电机株式会社 or 株式会社东京研发股份有限公司or 东京研发股份有限公司 or (东京R and D股份有限公司))) not (申请（专利权）人=(本田技研工业株式会社 or 住友电装株式会社 or 住友电气工业株式会社 or 雅马哈发动机株式会社or 丰田自动车株式会社 or 三菱扶桑卡客车株式会社 or 扶桑工程公司 or 丰田自动车株式会社or 安普泰科电子有限公司 or 松下电器产业株式会社 or 株式会社丰田自动织机 or 铃木株式会社 or 精工爱普生株式会社 or 株式会社东京研发股份有限公司 or 日野自动车工业株式会社 or 日本电池株式会社 or 三洋电机株式会社 or 日产自动车株式会社 or 矢崎总业株式会社 or 丰田自动车株式会社 or 株式会社东芝 or 日本电气株式会社 or 三洋电机株式会社 or 日立建机株式会社 or YKK株式会社 or 本田技研工业株式会社 or 株式会社NTT都科摩 or 新神户电机株式会社 or 株式会社东京研发股份有限公司or 东京研发股份有限公司 or (东京R and D股份有限公司)))";
		// s="(名称=(介质 and (谐振 and (器 or 装置))) or (摘要,主权项+=(介质 and (谐振器 or 谐振装置))))";
		s = "名称=(介质+谐振)";
		s = "pic=(A01K)";
		s= "(申请日=(19911201 to 20111130) and 公开（公告）日=(19911201 to 20111130) and 分类号=(C21B OR C21C OR C22C29/ OR C22C38/ OR B32B15/18) and 名称,摘要,主权项,权利要求书+=(%磁钢% OR %磁性钢% OR %电磁钢% OR %磁性%钢% OR %电磁%钢% OR %电工%钢% OR %电炉钢%))";
		
		s="公开（公告）日=(19911201 to 20111130) and 名称,摘要=('高铁')";
//		s="申请日=(1992 to 2012) and 公开（公告）日=(1992 to 2012.01.31) and 分类号=(B44C3/02 or B32B) and  (名称=(单板 or 贴面 or 木皮 or 饰面 or 胶合板 or 贴面板 or 饰面板) or 摘要=(单板 or 贴面 or 木皮 or 饰面 or 胶合板 or 贴面板 or 饰面板) or 权利要求书=(单板 or 贴面 or 木皮 or 饰面 or 胶合板 or 贴面板 or 饰面板))";
		s="申请号=(CN234342)";
		s="(((((((((名称=(容器 or 瓶 or 模块 or 过滤器) and (透析 or 渗透 or 渗析 or 洗肾 or 肾透 or 血透 or 体外循环 or 分离 or 成分采血 or 血 or 体液 or 净化 or 过滤 or 渗滤 or 渗析 or 吸附) or 摘要=(容器 or 瓶 or 模块 or 过滤器) and (透析 or 渗透 or 渗析 or 洗肾 or 肾透 or 血透 or 体外循环 or 分离 or 成分采血 or 血 or 体液 or 净化 or 过滤 or 渗滤 or 渗析 or 吸附) or 说明书=(容器 or 瓶 or 模块 or 过滤器) and (透析 or 渗透 or 渗析 or 洗肾 or 肾透 or 血透 or 体外循环 or 分离 or 成分采血 or 血 or 体液 or 净化 or 过滤 or 渗滤 or 渗析 or 吸附))) or ((主分类号=(24\\-01% or 24\\-02%) or 分类号=(24\\-01% or 24\\-02%))) or (((主分类号=(24\\-03% or 24\\-04%) or 分类号=(24\\-03% or 24\\-04%)) and (名称=(容器 or 瓶 or 透析 or 渗透 or 渗析 or 洗肾 or 肾透 or 血透 or 体外循环 or 分离 or 血 or 体液 or 净化 or 过滤 or 渗滤 or 渗析 or 吸附) or 摘要=(容器 or 瓶 or 透析 or 渗透 or 渗析 or 洗肾 or 肾透 or 血透 or 体外循环 or 分离 or 血 or 体液 or 净化 or 过滤 or 渗滤 or 渗析 or 吸附) or 说明书=(容器 or 瓶 or 透析 or 渗透 or 渗析 or 洗肾 or 肾透 or 血透 or 体外循环 or 分离 or 血 or 体液 or 净化 or 过滤 or 渗滤 or 渗析 or 吸附))))) and 申请日=(20021101 to 20121120))) not (名称=(半导体激光 or b超 or cb呼气试验机 or ct or drx光机 or hcg检测仪 or hcg检仪 or icu病房 or lcd显示器 or led or pca定量自控 or pcr扩增仪 or pcr仪 or pdp电视接收机 or ph计 or ph试纸 or tct or x光 or x射线 or x线 or x荧光 or 艾罐 or 艾灸 or 艾条 or 按摩 or 拔罐 or 咬合器 or 膀胱 or 包埋 or 保健 or 保洁柜 or 消毒柜 or 备皮 or 鼻窦镜 or 鼻骨 or 鼻镜 or 比色 or 闭合器 or 砭 or 标本 or 标识 or 标贴 or 冰箱 or 病理组 or 剥离器 or 采血针 or 采样器 or 彩超 or 超声 or 测控仪 or 测量 or 测试 or 茶 or 超声 or 超音 or 车架 or 针or 齿科 or 冲击波 or 冲奶宝 or 冲洗瓶 or 冲洗器 or 冲牙机 or 抽痰 or 抽吸装置 or 抽烟机 or 臭氧 or 除颤 or 除尘 or 厨房 or 橱柜 or 触摸屏 or 穿刺 or 传染病 or 床 or 创口 or 创面 or 锤 or 磁力 or 磁疗 or 磁性 or 磁珠仪 or 刺激 or 刺青 or 催乳 or 痤疮 or 打磨机 or 打头器 or 大便 or 大机架 or 大熊猫 or 胆道 or 胆囊 or 刀 or 导管 or 导航 or 等离子 or 点滴 or 电磁 or 电动锯 or 电极 or 电解 or 电疗 or 电麻 or 电凝 or 电热 or 电位治疗 or 电慰器 or 电针 or 电灼 or 电子镜 or 电钻 or 吊带 or 吊环 or 吊篮 or 钉砧 or 顶卡 or 顶锥 or 定位仪 or 定位针 or 定向仪 or 动物舱 or 豆浆 or 短波 or 多普勒 or 耳镜 or 二氧化氯 or 发动机 or 放大镜 or 放射 or 分配器 or 分水器 or 分析测试仪 or 分析物检测计 or 分析仪 or 粉碎器 or 缝合 or 缝针 or 复苏 or 复位器 or 腹腔镜 or 相机 or 干燥箱 or 肝素 or 肝肿瘤 or 坩埚 or 感应圈 or 肛肠镜 or 肛肠综合机 or 肛门镜 or 电离 or 电凝 or 高压静电 or 高压氧舱 or 给药器 or 给药装置 or 工作台 or 供氧机 or 压板 or 宫腔镜 or 钩板 or 骨 or 刮痧 or 关节镜 or 管理仪 or 灌肠 or 灌胃器 or 光疗 or 光谱 or 光纤 or 光治疗机 or 光子 or 广口瓶 or 柜 or 氦氖 or 焊枪 or 核磁共振 or 恒温槽 or 恒温器 or 红光治疗 or 红外 or 喉镜 or 喉罩 or 呼吸机 or 呼吸器 or 护理 or 化学实验台 or 化妆 or 灶 or 环锯 or 黄疸 or 刷 or 混凝土 or 混匀仪 or 活氧机 or 机箱 or 机油 or 肌肉 or 基台 or 基因 or 激光 or 急救 or 集成灶 or 计时诊 or 加热器 or 钳 or 监视 or 减压针 or 剪 or 检测 or 检查 or 健康 or 交锁钉 or 降压仪 or 焦度仪 or 角度基台 or 角膜 or 矫形 or 矫正 or 脚套 or 搅拌桨 or 螺钉 or 接种 or 节育 or 洁牙 or 结肠 or 解剖 or 筋膜 or 近视 or 经颅 or 经络 or 经皮 or 经穴 or 颈枕 or 颈椎 or 胫骨 or 痉挛 or 泵 or 镜体 or 灸 or 酒精 or 举宫器 or 均质机 or 咖啡 or 卡尺 or 开睑器 or 开口器 or 开瓶器 or 开水器 or 可视化设备 or 刻度表 or 空调 or 控制 or 口镜 or 口腔 or 叩诊 or 快速发药 or 髋骨 or 髋臼 or 窥器 or 窥视片 or 窥阴器 or 扩散器 or 扩张器 or 拉钩 or 蜡疗仪 or 蓝光仪 or 冷敷 or 冷光源 or 烧瓶 or 离心机 or 离子导入器 or 离子导入仪 or 理疗 or 流产吸引 or 流感器 or 留置针 or 麻醉 or 脉搏 or 脉动 or 脉枕 or 毛巾 or 酶标 or 面罩 or 内镜 or 内窥镜 or 内视镜 or 内诊镜 or 奶瓶 or 奶嘴 or 脑电 or 脑功能 or 脑循环 or 尿 or 尿检 or 暖奶器 or 排毒机 or 排卵 or 手机 or 培养 or 喷头 or 喷嘴 or 盆 or 皮肤 or 频谱仪 or 瓶贴 or 普勒仪 or 起搏器 or 气管 or 气囊 or 气压泵 or 汽车 or 牵引床 or 牵引器 or 前列腺 or 钳 or 腔镜 or 抢救仪 or 切割器 or 切片机 or 切削器 or 清洗槽 or 清洗器 or 取样 or 诊疗仪 or 燃料过滤器 or 染色机 or 热敷 or 热疗 or 热循环仪 or 热治疗机 or 人工呼吸器 or 人流 or 妊娠 or 乳房 or 乳腺 or 弱视 or 萨勃 or 扫描 or 多普勒 or 色谱 or 杀菌 or 舌苔刮 or 设备带 or 射频 or 摄影 or 神经 or 生化分析仪 or 生化仪 or 声仪器 or 失眠 or 实验 or 视力 or 试管 or 试剂 or 试条 or 试纸 or 手术 or 输气管 or 输液泵 or 输液袋 or 输液恒温器 or 输液架 or 输液监护器 or 输液瓶 or 输液器 or 输液软袋 or 输液仪 or 输液针保护套 or 输液针头 or 双极电凝 or 水疗 or 睡眠 or 塑卡 or 塑料卡 or 酸度仪 or 碎结石 or 碎石 or 碎脂机 or 胎儿监护仪 or 胎心 or 胎压 or 胎音 or 台车 or 糖尿病 or 听力 or 听诊 or 通风柜 or 通气机 or 通气仪 or 头线圈 or 投影机 or 透视机 or 挖耳勺 or 外科治疗 or 微波 or 卫生杯 or 卫生巾 or 胃镜 or 温疗器 or 纹身 or 手机 or 雾化 or 吸奶器 or 吸取器 or 吸乳器 or 吸入器 or 吸痰 or 吸唾 or 吸氧 or 吸引导管 or 吸引机 or 吸引器 or 吸脂机 or 洗板机 or 洗鼻器 or 洗片机 or 洗瓶 or 洗衣机 or 显示屏 or 显示器 or 显微镜 or 线圈 or 香烟 or 消毒 or 鞋 or 心电 or 血糖 or 血压 or 压舌板 or 压缩器 or 牙 or 眼睛 or 眼镜 or 眼科 or 胰岛素 or 移动工作站 or 阴道 or 音频音乐电疗仪 or 银汞调拌机 or 引产管 or 引流袋 or 引流管 or 引流瓶 or 引流器 or 引流针 or 泳池 or 泳动机 or 油烟机 or 油浴锅 or 诱发电位仪 or 鱼池 or 鱼缸 or 匀浆 or 载玻片 or 早孕 or 增效带 or 增氧机 or 站立架 or 针刀 or 针灸 or 针筒 or 针头 or 针治疗仪 or 针座 or 诊断 or 诊疗台 or 诊疗仪 or 振荡器 or 振动台 or 镇痛装置 or 震荡机 or 震荡器 or 蒸发器 or 蒸汽机 or 蒸煮机 or 止痛泵 or 止血带 or 止血器 or 指夹式脉搏血氧仪 or 指示灯 or 指套式脉搏血氧仪 or 制氧机 or 制氧器 or 治疗车 or 治疗带 or 治疗灯 or 治疗机 or 治疗盘 or 治疗器 or 治疗台 or 治疗贴 or 治疗头 or 治疗仪 or 质谱仪 or 中药 or 助视器 or 注射泵 or 注射器 or 注射针 or 注射装置 or 注液枪 or 紫外))))))";
		s="分类号=('C%' , 'G%' , 'H%')";
		s="名称,摘要,主权项+= ((抗真菌 OR (杀 AND 真菌)) OR (抑制 AND 真菌)) OR 主分类号='A61P31/10%'";
		s="(液冷 or 风冷)/ti and 雷达/ft,clm,ti,ab";
		s="分类号=('C09K11%' or 'H01J%') and 名称,摘要,主权项+=('very short afterlow' or 'very short fluorescent lag' or 'ultrashort afterglow' or 'ultrashort fluorescent lag' or 'less persistence')";
		s="分类号=(c10l3/00% or f02c3/28%) or 分类号=(F24J1/00% or F24J3/00% or F24J3/06%) or 分类号=(B61%) or 分类号=H02J or 分类号=(E04B1/62% or E04B1/74% or E04B1/76% or E04B1/78% or E04B1/80% or E04B1/88% or E04B1/90%) or 分类号=(F03G7/08%) or 分类号=(F03D%) or 分类号=( h01m4/86% or h01m4/88% or h01m4/90% or h01m4/92% or h01m4/94% or h01m4/96% or h01m4/98% or h01m8/00% or h01m8/02% or h01m8/04% or h01m8/06% or h01m8/08% or h01m8/10% or h01m8/12% or h01m8/14% or h01m8/16% or h01m8/18% or h01m8/20% or h01m8/22% or h01m8/24% or h01m12/00% or h01m12/02% or h01m12/04% or h01m12/06% or h01m12/08%)";
		s="计算机/CL";
		s="申请号=(cn85100048,cn85100169)";
		s = "AN,PNM+=('%%') ";
		// System.out.println(s);
		// InFormatString_left(s);
		try {
			s = (new GetSearchFormat()).preprocess(s);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(s);
	}
}
