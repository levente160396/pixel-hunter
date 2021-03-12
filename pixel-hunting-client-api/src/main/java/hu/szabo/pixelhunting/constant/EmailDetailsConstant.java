package hu.szabo.pixelhunting.constant;

/**
 * @author Szabó Levente
 *
 *         Replace String real data.
 */

public class EmailDetailsConstant {

	public static final String EMAIL_CHARSET = "text/html; charset=UTF-8";

	public static final String SESSION = "@SESSION@";

	public static final String NEW_SESSION = "@NEW_SESSION@";

	public static final String DISKSPACE = "@DISKSPACE@";

	public static final String MACHINE_MEMORY = "@MACHINE_MEMORY@";

	public static final String MACHINE_PROCESSOR = "@MACHINE_PROCESSOR@";

	public static final String SOFTWARE_MEMORY = "@SOFTWARE_MEMORY@";

	public static final String SOFTWARE_PROCESSOR = "@SOFTWARE_PROCESSOR@";
	
	public static final String CUSTOM = "@CUSTOM@";

	public static final String RIPORT_ITEM = "@RIPORT-ITEM@";

	public static final String RIPORT_TEMPLATE_TITLE = "@RIPORT_TEMPLATE_TITLE@";

	public static final String EMAIL_ADDRESS = "@EMAILADDRESS@";

	public static final String TITLE = "@TITLE@";

	public static final String EMAIL_TEXT = "@EMAILTEXT@";

	public static final String MAIN_CONTENT = "@MAIN_CONTENT@";

	public static final String IMAGE_TAG_START = "<img style=\"width: 400px; height: 400px\" src=\"cid:";

	public static final String IMAGE_TAG_END = "\">";

	public static final String FAILED_EMAIL_SUBJECT = "Failed to send email in monitoring app";

	public static final String DIAGRAM_DATE_STARTER_TAG = "<span style=\"font-weight: bold\">";

	public static final String DIAGRAM_DATE_END_TAG = "</span>";

	public static final String LINE_BREAK = "<br>";

	public static final String QUOTATION_MARK = " - ";

	private EmailDetailsConstant() {
	}
}
