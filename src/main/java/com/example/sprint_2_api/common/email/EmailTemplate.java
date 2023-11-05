package com.example.sprint_2_api.common.email;

public class EmailTemplate {
    public static String getTemplateEmail(String name, String OTP) {
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html dir=\"ltr\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                "    <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
                "    <title>color</title><!--[if (mso 16)]>\n" +
                "    <style type=\"text/css\">\n" +
                "        a {\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <![endif]--><!--[if gte mso 9]>\n" +
                "    <style>sup {\n" +
                "        font-size: 100% !important;\n" +
                "    }</style><![endif]--><!--[if gte mso 9]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:AllowPNG></o:AllowPNG>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml>\n" +
                "    <![endif]-->\n" +
                "    <style type=\"text/css\">\n" +
                "        #outlook a {\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        .es-button {\n" +
                "            mso-style-priority: 100 !important;\n" +
                "            text-decoration: none !important;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: none !important;\n" +
                "            font-size: inherit !important;\n" +
                "            font-family: inherit !important;\n" +
                "            font-weight: inherit !important;\n" +
                "            line-height: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        .es-desk-hidden {\n" +
                "            display: none;\n" +
                "            float: left;\n" +
                "            overflow: hidden;\n" +
                "            width: 0;\n" +
                "            max-height: 0;\n" +
                "            line-height: 0;\n" +
                "            mso-hide: all;\n" +
                "        }\n" +
                "\n" +
                "        .es-button-border:hover a.es-button, .es-button-border:hover button.es-button {\n" +
                "            background: #56d66b !important;\n" +
                "        }\n" +
                "\n" +
                "        .es-button-border:hover {\n" +
                "            background: #56d66b !important;\n" +
                "            border-color: #42d159 #42d159 #42d159 #42d159 !important;\n" +
                "        }\n" +
                "\n" +
                "        @media only screen and (max-width: 600px) {\n" +
                "            p, ul li, ol li, a {\n" +
                "                line-height: 150% !important\n" +
                "            }\n" +
                "\n" +
                "            h1, h2, h3, h1 a, h2 a, h3 a {\n" +
                "                line-height: 120% !important\n" +
                "            }\n" +
                "\n" +
                "            h1 {\n" +
                "                font-size: 30px !important;\n" +
                "                text-align: left\n" +
                "            }\n" +
                "\n" +
                "            h2 {\n" +
                "                font-size: 24px !important;\n" +
                "                text-align: left\n" +
                "            }\n" +
                "\n" +
                "            h3 {\n" +
                "                font-size: 20px !important;\n" +
                "                text-align: left\n" +
                "            }\n" +
                "\n" +
                "            .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a {\n" +
                "                font-size: 30px !important;\n" +
                "                text-align: left\n" +
                "            }\n" +
                "\n" +
                "            .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a {\n" +
                "                font-size: 24px !important;\n" +
                "                text-align: left\n" +
                "            }\n" +
                "\n" +
                "            .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a {\n" +
                "                font-size: 20px !important;\n" +
                "                text-align: left\n" +
                "            }\n" +
                "\n" +
                "            .es-menu td a {\n" +
                "                font-size: 14px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a {\n" +
                "                font-size: 14px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a {\n" +
                "                font-size: 14px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a {\n" +
                "                font-size: 14px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a {\n" +
                "                font-size: 12px !important\n" +
                "            }\n" +
                "\n" +
                "            *[class=\"gmail-fix\"] {\n" +
                "                display: none !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 {\n" +
                "                text-align: center !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 {\n" +
                "                text-align: right !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 {\n" +
                "                text-align: left !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img {\n" +
                "                display: inline !important\n" +
                "            }\n" +
                "\n" +
                "            .es-button-border {\n" +
                "                display: inline-block !important\n" +
                "            }\n" +
                "\n" +
                "            a.es-button, button.es-button {\n" +
                "                font-size: 18px !important;\n" +
                "                display: inline-block !important\n" +
                "            }\n" +
                "\n" +
                "            .es-adaptive table, .es-left, .es-right {\n" +
                "                width: 100% !important\n" +
                "            }\n" +
                "\n" +
                "            .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header {\n" +
                "                width: 100% !important;\n" +
                "                max-width: 600px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-adapt-td {\n" +
                "                display: block !important;\n" +
                "                width: 100% !important\n" +
                "            }\n" +
                "\n" +
                "            .adapt-img {\n" +
                "                width: 100% !important;\n" +
                "                height: auto !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0 {\n" +
                "                padding: 0 !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0r {\n" +
                "                padding-right: 0 !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0l {\n" +
                "                padding-left: 0 !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0t {\n" +
                "                padding-top: 0 !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0b {\n" +
                "                padding-bottom: 0 !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p20b {\n" +
                "                padding-bottom: 20px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-mobile-hidden, .es-hidden {\n" +
                "                display: none !important\n" +
                "            }\n" +
                "\n" +
                "            tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden {\n" +
                "                width: auto !important;\n" +
                "                overflow: visible !important;\n" +
                "                float: none !important;\n" +
                "                max-height: inherit !important;\n" +
                "                line-height: inherit !important\n" +
                "            }\n" +
                "\n" +
                "            tr.es-desk-hidden {\n" +
                "                display: table-row !important\n" +
                "            }\n" +
                "\n" +
                "            table.es-desk-hidden {\n" +
                "                display: table !important\n" +
                "            }\n" +
                "\n" +
                "            td.es-desk-menu-hidden {\n" +
                "                display: table-cell !important\n" +
                "            }\n" +
                "\n" +
                "            .es-menu td {\n" +
                "                width: 1% !important\n" +
                "            }\n" +
                "\n" +
                "            table.es-table-not-adapt, .esd-block-html table {\n" +
                "                width: auto !important\n" +
                "            }\n" +
                "\n" +
                "            table.es-social {\n" +
                "                display: inline-block !important\n" +
                "            }\n" +
                "\n" +
                "            table.es-social td {\n" +
                "                display: inline-block !important\n" +
                "            }\n" +
                "\n" +
                "            .es-desk-hidden {\n" +
                "                display: table-row !important;\n" +
                "                width: auto !important;\n" +
                "                overflow: visible !important;\n" +
                "                max-height: inherit !important\n" +
                "            }\n" +
                "\n" +
                "            .h-auto {\n" +
                "                height: auto !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p5 {\n" +
                "                padding: 5px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p5t {\n" +
                "                padding-top: 5px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p5b {\n" +
                "                padding-bottom: 5px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p5r {\n" +
                "                padding-right: 5px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p5l {\n" +
                "                padding-left: 5px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p10 {\n" +
                "                padding: 10px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p10t {\n" +
                "                padding-top: 10px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p10b {\n" +
                "                padding-bottom: 10px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p10r {\n" +
                "                padding-right: 10px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p10l {\n" +
                "                padding-left: 10px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p15 {\n" +
                "                padding: 15px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p15t {\n" +
                "                padding-top: 15px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p15b {\n" +
                "                padding-bottom: 15px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p15r {\n" +
                "                padding-right: 15px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p15l {\n" +
                "                padding-left: 15px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p20 {\n" +
                "                padding: 20px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p20t {\n" +
                "                padding-top: 20px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p20r {\n" +
                "                padding-right: 20px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p20l {\n" +
                "                padding-left: 20px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p25 {\n" +
                "                padding: 25px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p25t {\n" +
                "                padding-top: 25px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p25b {\n" +
                "                padding-bottom: 25px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p25r {\n" +
                "                padding-right: 25px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p25l {\n" +
                "                padding-left: 25px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p30 {\n" +
                "                padding: 30px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p30t {\n" +
                "                padding-top: 30px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p30b {\n" +
                "                padding-bottom: 30px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p30r {\n" +
                "                padding-right: 30px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p30l {\n" +
                "                padding-left: 30px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p35 {\n" +
                "                padding: 35px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p35t {\n" +
                "                padding-top: 35px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p35b {\n" +
                "                padding-bottom: 35px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p35r {\n" +
                "                padding-right: 35px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p35l {\n" +
                "                padding-left: 35px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p40 {\n" +
                "                padding: 40px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p40t {\n" +
                "                padding-top: 40px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p40b {\n" +
                "                padding-bottom: 40px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p40r {\n" +
                "                padding-right: 40px !important\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p40l {\n" +
                "                padding-left: 40px !important\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"background-color: black;width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
                "<div dir=\"ltr\" class=\"es-wrapper-color\" lang=\"en\" style=\"background-color:black\"><!--[if gte mso 9]>\n" +
                "    <v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "        <v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
                "    </v:background>\n" +
                "    <![endif]-->\n" +
                "    <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"none\"\n" +
                "           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:black\">\n" +
                "        <tr>\n" +
                "            <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                "                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" role=\"none\"\n" +
                "                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "                            <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#0e0c0c\"\n" +
                "                                   align=\"center\"\n" +
                "                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:black;width:600px\"\n" +
                "                                   role=\"none\">\n" +
                "                                <tr>\n" +
                "                                    <td align=\"left\"\n" +
                "                                        style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
                "                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"none\"\n" +
                "                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                            <tr>\n" +
                "                                                <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                           role=\"presentation\"\n" +
                "                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                        <tr>\n" +
                "                                                            <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\">\n" +
                "                                                                <img class=\"adapt-img\"\n" +
                "                                                                     src=\"https://i.imgur.com/3rFWFd6.png\"\n" +
                "                                                                     alt\n" +
                "                                                                     style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"\n" +
                "                                                                     width=\"410\"></td>\n" +
                "                                                        </tr>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td align=\"left\"\n" +
                "                                        style=\"Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;padding-bottom:30px\">\n" +
                "                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"none\"\n" +
                "                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                            <tr>\n" +
                "                                                <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                           role=\"presentation\"\n" +
                "                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                        <tr>\n" +
                "                                                            <td align=\"left\" style=\"padding:0;Margin:0\"><p\n" +
                "                                                                    style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#fbfafa;font-size:14px\">\n" +
                "                                                                Xin chào " + name + "\n" +
                "                                                                <br><br/>\n" +
                "\n" +
                "                                                                <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#fbfafa;font-size:14px\">\n" +
                "                                                                    Vì mục đích bảo mật, bạn được yêu cầu phải sử dụng\n" +
                "                                                                    mật khẩu OTP:<br><br><b>" + OTP + "</b><br><br>Ghi chú: OTP sẽ chỉ có\n" +
                "                                                                    hiệu lực trong 5 phút.</p>\n" +
                "                                                                <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#fbfafa;font-size:14px\">\n" +
                "                                                                    <br></p>\n" +
                "                                                                <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#fbfafa;font-size:14px\">\n" +
                "                                                                    Chúc bạn một ngày làm việc vui vẻ</p></td>\n" +
                "                                                        </tr>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }

    public static String getEmailUrl(String name, String URL) {
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html dir=\"ltr\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"vi\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                "    <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
                "    <title>color</title> <!--[if (mso 16)]>\n" +
                "    <style type=\"text/css\">     a {\n" +
                "        text-decoration: none;\n" +
                "    }     </style><![endif]--> <!--[if gte mso 9]>\n" +
                "    <style>sup {\n" +
                "        font-size: 100% !important;\n" +
                "    }</style><![endif]--> <!--[if gte mso 9]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:AllowPNG></o:AllowPNG>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml>\n" +
                "    <![endif]-->\n" +
                "    <style type=\"text/css\">#outlook a {\n" +
                "        padding: 0;\n" +
                "    }\n" +
                "\n" +
                "    .es-button {\n" +
                "        mso-style-priority: 100 !important;\n" +
                "        text-decoration: none !important;\n" +
                "    }\n" +
                "\n" +
                "    a[x-apple-data-detectors] {\n" +
                "        color: inherit !important;\n" +
                "        text-decoration: none !important;\n" +
                "        font-size: inherit !important;\n" +
                "        font-family: inherit !important;\n" +
                "        font-weight: inherit !important;\n" +
                "        line-height: inherit !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-desk-hidden {\n" +
                "        display: none;\n" +
                "        float: left;\n" +
                "        overflow: hidden;\n" +
                "        width: 0;\n" +
                "        max-height: 0;\n" +
                "        line-height: 0;\n" +
                "        mso-hide: all;\n" +
                "    }\n" +
                "\n" +
                "    .es-button-border:hover a.es-button, .es-button-border:hover button.es-button {\n" +
                "        background: #56d66b !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-button-border:hover {\n" +
                "        background: #56d66b !important;\n" +
                "        border-color: #42d159 #42d159 #42d159 #42d159 !important;\n" +
                "    }\n" +
                "\n" +
                "    td .es-button-border:hover a.es-button-1699001773707 {\n" +
                "        background: #e5e5e5 !important;\n" +
                "        color: #000000 !important;\n" +
                "    }\n" +
                "\n" +
                "    td .es-button-border-1699001773726:hover {\n" +
                "        background: #e5e5e5 !important;\n" +
                "        border-style: solid solid solid solid !important;\n" +
                "        border-color: #42d159 #42d159 #42d159 #42d159 !important;\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 600px) {\n" +
                "        p, ul li, ol li, a {\n" +
                "            line-height: 150% !important\n" +
                "        }\n" +
                "\n" +
                "        h1, h2, h3, h1 a, h2 a, h3 a {\n" +
                "            line-height: 120% !important\n" +
                "        }\n" +
                "\n" +
                "        h1 {\n" +
                "            font-size: 30px !important;\n" +
                "            text-align: left\n" +
                "        }\n" +
                "\n" +
                "        h2 {\n" +
                "            font-size: 24px !important;\n" +
                "            text-align: left\n" +
                "        }\n" +
                "\n" +
                "        h3 {\n" +
                "            font-size: 20px !important;\n" +
                "            text-align: left\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a {\n" +
                "            font-size: 30px !important;\n" +
                "            text-align: left\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a {\n" +
                "            font-size: 24px !important;\n" +
                "            text-align: left\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a {\n" +
                "            font-size: 20px !important;\n" +
                "            text-align: left\n" +
                "        }\n" +
                "\n" +
                "        .es-menu td a {\n" +
                "            font-size: 14px !important\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a {\n" +
                "            font-size: 14px !important\n" +
                "        }\n" +
                "\n" +
                "        .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a {\n" +
                "            font-size: 14px !important\n" +
                "        }\n" +
                "\n" +
                "        .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a {\n" +
                "            font-size: 14px !important\n" +
                "        }\n" +
                "\n" +
                "        .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a {\n" +
                "            font-size: 12px !important\n" +
                "        }\n" +
                "\n" +
                "        *[class=\"gmail-fix\"] {\n" +
                "            display: none !important\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "        .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img {\n" +
                "            display: inline !important\n" +
                "        }\n" +
                "\n" +
                "        .es-button-border {\n" +
                "            display: inline-block !important\n" +
                "        }\n" +
                "\n" +
                "        a.es-button, button.es-button {\n" +
                "            font-size: 18px !important;\n" +
                "            display: inline-block !important\n" +
                "        }\n" +
                "\n" +
                "        .es-adaptive table, .es-left, .es-right {\n" +
                "            width: 100% !important\n" +
                "        }\n" +
                "\n" +
                "        .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header {\n" +
                "            width: 100% !important;\n" +
                "            max-width: 600px !important\n" +
                "        }\n" +
                "\n" +
                "        .adapt-img {\n" +
                "            width: 100% !important;\n" +
                "            height: auto !important\n" +
                "        }\n" +
                "\n" +
                "        .es-menu td {\n" +
                "            width: 1% !important\n" +
                "        }\n" +
                "\n" +
                "        table.es-social td {\n" +
                "            display: inline-block !important\n" +
                "        }\n" +
                "    }</style>\n" +
                "</head>\n" +
                "<body style=\"background-color: black;width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
                "<div dir=\"ltr\" class=\"es-wrapper-color\" lang=\"vi\" style=\"background-color:#F6F6F6\"> <!--[if gte mso 9]>\n" +
                "    <v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "        <v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
                "    </v:background><![endif]-->\n" +
                "    <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"none\"\n" +
                "           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#F6F6F6\">\n" +
                "        <tr>\n" +
                "            <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                "                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" role=\"none\"\n" +
                "                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "                            <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#0e0c0c\"\n" +
                "                                   align=\"center\"\n" +
                "                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#0e0c0c;width:600px\"\n" +
                "                                   role=\"none\">\n" +
                "                                <tr>\n" +
                "                                    <td align=\"left\"\n" +
                "                                        style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
                "                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"none\"\n" +
                "                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                            <tr>\n" +
                "                                                <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                           role=\"presentation\"\n" +
                "                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                        <tr>\n" +
                "                                                            <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\">\n" +
                "                                                                <img class=\"adapt-img\"\n" +
                "                                                                     src=\"https://i.imgur.com/3rFWFd6.png\"\n" +
                "                                                                     alt\n" +
                "                                                                     style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"\n" +
                "                                                                     width=\"410\" height=\"163\"></td>\n" +
                "                                                        </tr>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td align=\"left\"\n" +
                "                                        style=\"Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;padding-bottom:30px\">\n" +
                "                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"none\"\n" +
                "                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                            <tr>\n" +
                "                                                <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                           role=\"presentation\"\n" +
                "                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                        <tr>\n" +
                "                                                            <td align=\"left\" style=\"padding:0;Margin:0\"><p\n" +
                "                                                                    style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#fbfafa;font-size:14px\">\n" +
                "                                                                Xin chào " + name + "<br><br></p>\n" +
                "                                                                <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#fbfafa;font-size:14px\">\n" +
                "                                                                    Chúng tôi nhận được yêu cầu Đặt lại mật\n" +
                "                                                                    khẩu.<br><br>Ghi chú: Email sẽ chỉ có hiệu lực trong\n" +
                "                                                                    5 phút.</p>\n" +
                "                                                                <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#fbfafa;font-size:14px\">\n" +
                "                                                                    <br></p>\n" +
                "                                                                <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#fbfafa;font-size:14px\">\n" +
                "                                                                    Chúc bạn một ngày làm việc vui vẻ.</p></td>\n" +
                "                                                        </tr>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td align=\"left\"\n" +
                "                                        style=\"Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;padding-bottom:30px\">\n" +
                "                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"none\"\n" +
                "                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                            <tr>\n" +
                "                                                <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                           role=\"presentation\"\n" +
                "                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                        <tr>\n" +
                "                                                            <td align=\"center\" style=\"padding:0;Margin:0\"> <!--[if mso]>\n" +
                "                                                                <a href=\" " + URL + " \"\n" +
                "                                                                   target=\"_blank\" hidden>\n" +
                "                                                                    <v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "                                                                                 xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
                "                                                                                 esdevVmlButton\n" +
                "                                                                                 href=\" " + URL + "\"\n" +
                "                                                                                 style=\"height:41px; v-text-anchor:middle; width:189px\"\n" +
                "                                                                                 arcsize=\"27%\" stroke=\"f\"\n" +
                "                                                                                 fillcolor=\"#ffffff\">\n" +
                "                                                                        <w:anchorlock></w:anchorlock>\n" +
                "                                                                        <center style='color:#333333; font-family:arial, \"helvetica neue\", helvetica, sans-serif; font-size:15px; font-weight:400; line-height:15px; mso-text-raise:1px'>\n" +
                "                                                                            Đặt lại mật khẩu\n" +
                "                                                                        </center>\n" +
                "                                                                    </v:roundrect>\n" +
                "                                                                </a>\n" +
                "                                                                <![endif]--> <!--[if !mso]><!-- --><span\n" +
                "                                                                        class=\"msohide es-button-border-1699001773726 es-button-border\"\n" +
                "                                                                        style=\"border-style:solid;border-color:#2cb543;background:#ffffff;border-width:0px;display:inline-block;border-radius:11px;width:auto;mso-hide:all\"><a\n" +
                "                                                                        href=\" " + URL + " \"\n" +
                "                                                                        class=\"es-button es-button-1699001773707\"\n" +
                "                                                                        target=\"_blank\"\n" +
                "                                                                        style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;color:#333333;font-size:18px;display:inline-block;background:#ffffff;border-radius:11px;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center;padding:10px 20px 10px 20px;mso-padding-alt:0;mso-border-alt:10px solid #31CB4B\">Đặt lại mật khẩu</a> </span>\n" +
                "                                                                <!--<![endif]--></td>\n" +
                "                                                        </tr>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }

}
