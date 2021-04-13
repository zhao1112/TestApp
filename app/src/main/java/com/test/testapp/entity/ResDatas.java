package com.test.testapp.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cuiChenBo
 * Created by zz on 2018/3/6 14:17.
 * 　　class explain:
 * 　　　　update:       upAuthor:      explain:
 */

public class ResDatas implements Serializable {

    public static String homeIcon[] = {
            "全球直购", "价格区间", "优选好店", "会员专区", "热门直播"
    };


    public static String bannerimages[] = {
            "http://gank.io/images/ccf0316264d245018fc651cffa6e90de",
            "http://gank.io/images/e92911f5ff9446d5a899b652b1934b93",
            "http://gank.io/images/f12526b3e9654a47842db6ce21222874",
            "http://gank.io/images/f08e8ab6030d41a0ada3e6cecea0e60c",
            "http://gank.io/images/fb1c315d54e1413494223aca31a9c47c",
            "http://gank.io/images/3fdbaffdf3374578a82313621123dace",
            "http://gank.io/images/6e57b254da79416bbe58248b570ea85f",
            "http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2",
            "http://gank.io/images/bdb35e4b3c0045c799cc7a494a3db3e0"
    };

    public static String minimages[] = {
            "http://gank.io/images/ccf0316264d245018fc651cffa6e90de",
            "http://gank.io/images/e92911f5ff9446d5a899b652b1934b93",
            "http://gank.io/images/f12526b3e9654a47842db6ce21222874",
            "http://gank.io/images/f08e8ab6030d41a0ada3e6cecea0e60c",
            "http://gank.io/images/fb1c315d54e1413494223aca31a9c47c",
            "http://gank.io/images/3fdbaffdf3374578a82313621123dace",
            "http://gank.io/images/6e57b254da79416bbe58248b570ea85f",
            "http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2",
            "http://gank.io/images/bdb35e4b3c0045c799cc7a494a3db3e0",
            "http://gank.io/images/f0c192e3e335400db8a709a07a891b2e",
            "http://gank.io/images/19c99c447e0a40a6b3ff89951957cfb1",
            "http://gank.io/images/25d3e3db2c1248bb917c09dc4f50a46f",
            "http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b",
            "http://gank.io/images/9fa43020cf724c69842eec3e13f6d21c",
            "http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149",
            "http://gank.io/images/6b2efa591564475fb8bc32291fb0007c",
            "http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320",
            "http://gank.io/images/f4f6d68bf30147e1bdd4ddbc6ad7c2a2",
            "http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2",
            "http://gank.io/images/6e57b254da79416bbe58248b570ea85f",
            "http://gank.io/images/e343db89daff4937b28e82a275024cf7",
            "http://gank.io/images/e831e004436f4fffb657a77aef48b9ca",
            "http://gank.io/images/6f1708af33d647f3809ea551e18894ce",
            "http://gank.io/images/341ecaacdd7d4cc09cd0de100f3eab46",
            "http://gank.io/images/7878d08eb776401a85deeb203372665c",
            "http://gank.io/images/7f64754ca07e4af3a242399fd37c2432",
            "http://gank.io/images/cdd7031fa92d40e18a715035b686b4c4",
            "http://gank.io/images/58389e1189534e1cb75b7a788f6b8a86",
            "http://gank.io/images/9770422c45294684af50f725049d7c07",
            "http://gank.io/images/54fc1a56dbc44b52b23714030a457a1b",
            "http://gank.io/images/0fdac44dada5489b85049a3f3fb7fd85",
            "http://gank.io/images/79f717dc495645dfb4e9c43f4674fa30",
            "http://gank.io/images/e6b78c1949d5438fa37ff2f272e5f1d0",
            "http://gank.io/images/a0388326c2b04aa1a58aa956276c40e3"
    };

    public static String[] minheight = {
            "250", "216", "258", "225", "227", "244", "214", "245", "212", "240",
            "267", "233", "241", "222", "254", "231", "241", "221", "228", "216",
            "258", "235", "247", "242", "257", "267", "265", "260", "232", "264",
            "252", "228", "246", "233"
    };

    public static String[] videoDatas = {
            "http://jzvd.nathen.cn/6ea7357bc3fa4658b29b7933ba575008/fbbba953374248eb913cb1408dc61d85-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/35b3dc97fbc240219961bd1fccc6400b/8d9b76ab5a584bce84a8afce012b72d3-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/df6096e7878541cbbea3f7298683fbed/ef76450342914427beafe9368a4e0397-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/384d341e000145fb82295bdc54ecef88/103eab5afca34baebc970378dd484942-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/f55530ba8a59403da0621cbf4faef15e/adae4f2e3ecf4ea780beb057e7bce84c-5287d2089db37e62345123a1be272f8b.mp4"

    };

    public static String unifiedIcon[] = {
            "阿里拍卖", "充值中心", "双11抢购", "直播", "领橘币"
    };

    public static List<String> getVideoDatas() {
        return Arrays.asList(videoDatas);
    }

    public static List<String> getBannerImages() {
        return Arrays.asList(bannerimages);
    }

    public static List<String> getMin() {
        return Arrays.asList(minimages);
    }

    public static List<String> getHeight() {
        return Arrays.asList(minheight);
    }

    public static List<String> getHomeIcon() {
        return Arrays.asList(homeIcon);
    }

    public static List<String> getUnifiedIcon() {
        return Arrays.asList(unifiedIcon);
    }
}
