package com.brulser.graduationproject.javabean;

import android.annotation.TargetApi;

import org.greenrobot.greendao.annotation.Entity;

import java.util.List;

/**
 * Created by pc on 2017/4/26.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class News {

    /**
     * status : 0
     * msg : ok
     * result : {"channel":"头条","num":"1","list":[{"title":"张馨予小号对李晨冰冰怨念深?","time":"2017-04-26 20:37","src":"新浪娱乐","category":"ent","pic":"http://api.jisuapi.com/news/upload/20170426/210001_22778.jpg","content":"<p class=\"art_t\">Ran/文 宸安/文<\/p><p class=\"art_t\">新浪娱乐讯 4月26日，据\u201c关八\u201d爆料，疑似张馨予的小号被网友扒出。从内容、手机型号以及配图等各方面分析，该账号的主人是张馨予的可能性非常之大，令人惊讶的是，该账号主人疑似遭到其他艺人打压，怨恨李晨为保护范冰冰而对自己冷酷无情。<\/p><p class=\"art_t\">从该账号的个人信息来看，该账号于2015年4月3日注册，距今有两年多的时间，截至目前为止，这个微博账号已经发布了191条内容，微博的简介里则写着这是一个\u201c负面情绪的私人垃圾桶\u201d，似乎该账号的主人将这个微博作为宣泄情绪的出口。<\/p><p class=\"art_t\">有网友从内容、手机型号以及微博配图等几个方面罗列六大证据，证明该微博账号的主人是张馨予。<\/p><p class=\"art_t\">证据一：点赞张馨予自拍<\/p><p class=\"art_t\">翻看两年中的所有微博，该账号的主人只点赞过两张图片，其中一张便是张馨予当年去戛纳电影节时发在微博上的自拍。<\/p><p class=\"art_t\">证据二：同样的时间段内更换同样的手机型号<\/p><p class=\"art_t\">该账号的主人在2016年12月中下旬更换手机型号，而张馨予的微博大号也在在同样的时间段里，更换了同样的手机型号。<\/p><p class=\"art_t\">证据三：喜欢的食物一致<\/p><p class=\"art_t\">该微博账号的主人曾透露自己最爱冬阴功粉，并晒出图片，张馨予本人曾在微博大号上晒图并放话\u201c回北京必须吃冬阴功汤\u201d，而且两个微博图中的碗垫一模一样。<\/p><p class=\"art_t\">证据四：<\/p><p class=\"art_t\">该微博账号于在16年6月14日分享了印有日文的水果，证明该账号主人极有可能在日本。同一天，张馨予通过微博晒出一张日文包装纸的冰淇淋图片，有网友还爆料称，12日当天在日本偶遇张馨予吃烤肉。<\/p><p class=\"art_t\">证据五：<\/p><p class=\"art_t\">去年平安夜，该微博账号曾晒出一张西瓜的照片，配文称吃西瓜时，喜欢先挖中间。张馨予在圣诞直播中，恰好现场吃西瓜，并且也是从中间开挖。<\/p><p class=\"art_t\">证据六：<\/p><p class=\"art_t\">最让人怀疑该账号的主人是张馨予的一点是，2016年6月8日，张馨予在微博中晒出三球冰淇淋的照片，而账号微博在16年的6月6日提前发布了一模一样的冰淇淋照片。<\/p><p class=\"art_t\">从以上种种迹象来看，该账号的主人很可能是张馨予。这个账号所发布的微博内容信息量较大，且负能量爆棚。<\/p><p class=\"art_t\">信息量一：张馨予疑似遭遇打压<\/p><p class=\"art_t\">在微博小号中，该账号主人曾多次抱怨自己遭遇出席发布会被删稿、看秀被除名，甚至被封杀的事件。4月1日当天，该账号主人还在小号中用拼音缩写隐晦地透露有人阻止自己参加《思美人》在《快乐大本营》的宣传录制。<\/p><p class=\"art_t\">信息量二：疑似对范冰冰李晨怨念深<\/p><p class=\"art_t\">该账号的主人曾痛恨地提到\u201c公开信\u201d对自己造成的伤害，放狠话称：\u201c事到如今依然被你的公开信诟病，我到底做了什么伤害她的事？以我的性格，应该直接回馈你一封公开信！要撕就撕，别玩阴的！\u201d似乎疑指前任李晨早前发布的长文爆料张馨予出轨。去年平安夜，该小号直接痛斥道：\u201c我们分开以后互不亏欠，但分开后的两年时间，她如此对我，暗里对我做的事你也应该知道，可你亲自出马，要赶尽杀绝\u2026\u2026\u201d让人不免想到李晨和张馨予分手后，曾几次保护范冰冰，斥责张馨予的态度。<\/p><p class=\"art_t\">（Ran/文 宸安/文）<\/p>","url":"http://ent.sina.cn/star/tv/2017-04-26/detail-ifyetwsm0465100.d.html?vt=4&pos=108","weburl":"http://ent.sina.com.cn/s/m/2017-04-26/doc-ifyetwsm0465100.shtml"}]}
     */


    private String status;
    private String msg;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * channel : 头条
         * num : 1
         * list : [{"title":"张馨予小号对李晨冰冰怨念深?","time":"2017-04-26 20:37","src":"新浪娱乐","category":"ent","pic":"http://api.jisuapi.com/news/upload/20170426/210001_22778.jpg","content":"<p class=\"art_t\">Ran/文 宸安/文<\/p><p class=\"art_t\">新浪娱乐讯 4月26日，据\u201c关八\u201d爆料，疑似张馨予的小号被网友扒出。从内容、手机型号以及配图等各方面分析，该账号的主人是张馨予的可能性非常之大，令人惊讶的是，该账号主人疑似遭到其他艺人打压，怨恨李晨为保护范冰冰而对自己冷酷无情。<\/p><p class=\"art_t\">从该账号的个人信息来看，该账号于2015年4月3日注册，距今有两年多的时间，截至目前为止，这个微博账号已经发布了191条内容，微博的简介里则写着这是一个\u201c负面情绪的私人垃圾桶\u201d，似乎该账号的主人将这个微博作为宣泄情绪的出口。<\/p><p class=\"art_t\">有网友从内容、手机型号以及微博配图等几个方面罗列六大证据，证明该微博账号的主人是张馨予。<\/p><p class=\"art_t\">证据一：点赞张馨予自拍<\/p><p class=\"art_t\">翻看两年中的所有微博，该账号的主人只点赞过两张图片，其中一张便是张馨予当年去戛纳电影节时发在微博上的自拍。<\/p><p class=\"art_t\">证据二：同样的时间段内更换同样的手机型号<\/p><p class=\"art_t\">该账号的主人在2016年12月中下旬更换手机型号，而张馨予的微博大号也在在同样的时间段里，更换了同样的手机型号。<\/p><p class=\"art_t\">证据三：喜欢的食物一致<\/p><p class=\"art_t\">该微博账号的主人曾透露自己最爱冬阴功粉，并晒出图片，张馨予本人曾在微博大号上晒图并放话\u201c回北京必须吃冬阴功汤\u201d，而且两个微博图中的碗垫一模一样。<\/p><p class=\"art_t\">证据四：<\/p><p class=\"art_t\">该微博账号于在16年6月14日分享了印有日文的水果，证明该账号主人极有可能在日本。同一天，张馨予通过微博晒出一张日文包装纸的冰淇淋图片，有网友还爆料称，12日当天在日本偶遇张馨予吃烤肉。<\/p><p class=\"art_t\">证据五：<\/p><p class=\"art_t\">去年平安夜，该微博账号曾晒出一张西瓜的照片，配文称吃西瓜时，喜欢先挖中间。张馨予在圣诞直播中，恰好现场吃西瓜，并且也是从中间开挖。<\/p><p class=\"art_t\">证据六：<\/p><p class=\"art_t\">最让人怀疑该账号的主人是张馨予的一点是，2016年6月8日，张馨予在微博中晒出三球冰淇淋的照片，而账号微博在16年的6月6日提前发布了一模一样的冰淇淋照片。<\/p><p class=\"art_t\">从以上种种迹象来看，该账号的主人很可能是张馨予。这个账号所发布的微博内容信息量较大，且负能量爆棚。<\/p><p class=\"art_t\">信息量一：张馨予疑似遭遇打压<\/p><p class=\"art_t\">在微博小号中，该账号主人曾多次抱怨自己遭遇出席发布会被删稿、看秀被除名，甚至被封杀的事件。4月1日当天，该账号主人还在小号中用拼音缩写隐晦地透露有人阻止自己参加《思美人》在《快乐大本营》的宣传录制。<\/p><p class=\"art_t\">信息量二：疑似对范冰冰李晨怨念深<\/p><p class=\"art_t\">该账号的主人曾痛恨地提到\u201c公开信\u201d对自己造成的伤害，放狠话称：\u201c事到如今依然被你的公开信诟病，我到底做了什么伤害她的事？以我的性格，应该直接回馈你一封公开信！要撕就撕，别玩阴的！\u201d似乎疑指前任李晨早前发布的长文爆料张馨予出轨。去年平安夜，该小号直接痛斥道：\u201c我们分开以后互不亏欠，但分开后的两年时间，她如此对我，暗里对我做的事你也应该知道，可你亲自出马，要赶尽杀绝\u2026\u2026\u201d让人不免想到李晨和张馨予分手后，曾几次保护范冰冰，斥责张馨予的态度。<\/p><p class=\"art_t\">（Ran/文 宸安/文）<\/p>","url":"http://ent.sina.cn/star/tv/2017-04-26/detail-ifyetwsm0465100.d.html?vt=4&pos=108","weburl":"http://ent.sina.com.cn/s/m/2017-04-26/doc-ifyetwsm0465100.shtml"}]
         */

        private String channel;
        private String num;
        private List<ListBean> list;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * title : 张馨予小号对李晨冰冰怨念深?
             * time : 2017-04-26 20:37
             * src : 新浪娱乐
             * category : ent
             * pic : http://api.jisuapi.com/news/upload/20170426/210001_22778.jpg
             * content : <p class="art_t">Ran/文 宸安/文</p><p class="art_t">新浪娱乐讯 4月26日，据“关八”爆料，疑似张馨予的小号被网友扒出。从内容、手机型号以及配图等各方面分析，该账号的主人是张馨予的可能性非常之大，令人惊讶的是，该账号主人疑似遭到其他艺人打压，怨恨李晨为保护范冰冰而对自己冷酷无情。</p><p class="art_t">从该账号的个人信息来看，该账号于2015年4月3日注册，距今有两年多的时间，截至目前为止，这个微博账号已经发布了191条内容，微博的简介里则写着这是一个“负面情绪的私人垃圾桶”，似乎该账号的主人将这个微博作为宣泄情绪的出口。</p><p class="art_t">有网友从内容、手机型号以及微博配图等几个方面罗列六大证据，证明该微博账号的主人是张馨予。</p><p class="art_t">证据一：点赞张馨予自拍</p><p class="art_t">翻看两年中的所有微博，该账号的主人只点赞过两张图片，其中一张便是张馨予当年去戛纳电影节时发在微博上的自拍。</p><p class="art_t">证据二：同样的时间段内更换同样的手机型号</p><p class="art_t">该账号的主人在2016年12月中下旬更换手机型号，而张馨予的微博大号也在在同样的时间段里，更换了同样的手机型号。</p><p class="art_t">证据三：喜欢的食物一致</p><p class="art_t">该微博账号的主人曾透露自己最爱冬阴功粉，并晒出图片，张馨予本人曾在微博大号上晒图并放话“回北京必须吃冬阴功汤”，而且两个微博图中的碗垫一模一样。</p><p class="art_t">证据四：</p><p class="art_t">该微博账号于在16年6月14日分享了印有日文的水果，证明该账号主人极有可能在日本。同一天，张馨予通过微博晒出一张日文包装纸的冰淇淋图片，有网友还爆料称，12日当天在日本偶遇张馨予吃烤肉。</p><p class="art_t">证据五：</p><p class="art_t">去年平安夜，该微博账号曾晒出一张西瓜的照片，配文称吃西瓜时，喜欢先挖中间。张馨予在圣诞直播中，恰好现场吃西瓜，并且也是从中间开挖。</p><p class="art_t">证据六：</p><p class="art_t">最让人怀疑该账号的主人是张馨予的一点是，2016年6月8日，张馨予在微博中晒出三球冰淇淋的照片，而账号微博在16年的6月6日提前发布了一模一样的冰淇淋照片。</p><p class="art_t">从以上种种迹象来看，该账号的主人很可能是张馨予。这个账号所发布的微博内容信息量较大，且负能量爆棚。</p><p class="art_t">信息量一：张馨予疑似遭遇打压</p><p class="art_t">在微博小号中，该账号主人曾多次抱怨自己遭遇出席发布会被删稿、看秀被除名，甚至被封杀的事件。4月1日当天，该账号主人还在小号中用拼音缩写隐晦地透露有人阻止自己参加《思美人》在《快乐大本营》的宣传录制。</p><p class="art_t">信息量二：疑似对范冰冰李晨怨念深</p><p class="art_t">该账号的主人曾痛恨地提到“公开信”对自己造成的伤害，放狠话称：“事到如今依然被你的公开信诟病，我到底做了什么伤害她的事？以我的性格，应该直接回馈你一封公开信！要撕就撕，别玩阴的！”似乎疑指前任李晨早前发布的长文爆料张馨予出轨。去年平安夜，该小号直接痛斥道：“我们分开以后互不亏欠，但分开后的两年时间，她如此对我，暗里对我做的事你也应该知道，可你亲自出马，要赶尽杀绝……”让人不免想到李晨和张馨予分手后，曾几次保护范冰冰，斥责张馨予的态度。</p><p class="art_t">（Ran/文 宸安/文）</p>
             * url : http://ent.sina.cn/star/tv/2017-04-26/detail-ifyetwsm0465100.d.html?vt=4&pos=108
             * weburl : http://ent.sina.com.cn/s/m/2017-04-26/doc-ifyetwsm0465100.shtml
             */

            private String title;
            private String time;
            private String src;
            private String category;
            private String pic;
            private String content;
            private String url;
            private String weburl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getWeburl() {
                return weburl;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }
        }
    }
}
