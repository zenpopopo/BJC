/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc;

/**
 *
 * 定数クラス。
 *
 * @author zempo
 */
public class Constants {

    /**
     * コンストラクタ。
     */
    private Constants() {
        // インスタンスの生成を抑止。
    }

    public enum Flg {

        ON("1"),
        OFF("0");

        private final String flg;

        private Flg(String flg) {
            this.flg = flg;
        }

        public String getCode() {
            return this.flg;
        }
    }

    /**
     * 申請ステータス。
     */
    public enum PetitionStatus {
        APPROVAL(10, "承認"),
        APPLYING(11, "申請中"),
        REVIEW(12, "検討中"),
        DISSMISSAL(13, "却下");

        private final Integer id;
        private final String name;

        private PetitionStatus(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * 優先度。
     */
    public enum Priority {
        NOMAL(2, "通常"),
        EARLY(10, "早め"),
        HURRY(4, "急いで");

        private final Integer id;
        private final String name;

        private Priority(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum Tracker {

    }

    /**
     * カスタムフィールド。
     */
    public enum CustomFields {
        PETITION_CATEGORY(1, "申請種別"),
        AMOUNT(2, "金額"),
        REFERENCE_URL(3, "参考URL"),
        AUTHORIZER(4, "承認者");

        private final Integer id;
        private final String name;

        private CustomFields(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getid() {
            return this.id;
        }

        public String getNmae() {
            return this.name;
        }
    }

    /**
     * 申請種別。
     */
    public enum PetitionCategory {

        RECEIPT(1, "領収書申請"),
        TRAVEL(2, "出張費申請"),
        GOODS(3, "物品購入申請"),
        OTHERS(4, "その他");

        private final Integer id;
        private final String name;

        private PetitionCategory(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }
}
