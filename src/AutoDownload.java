import java.util.List;

public class AutoDownload {

    public static void main(String[] args) {
        String[] m3u8Address={
                "https://apd-6da91c2f357b2e6d03c9163268c647d6.v.smtcdns.com/moviets.tc.qq.com/AOloicdi0N5912VfTmRVuQfFnzM9mrEYRAm8x89tBx9A/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/KThZUWJLEfcjOB01Ft5YiKrWa9KmBZUMBsOFOIjJms06Qd8oGhVHUq816ZMAjxclEGnciVrMHCqYxjH9KUNxOFYUweu3iQXiMFZUhYm3oNsrm60s7ybMB6YhhnO6C_32jKRnennQBqC1sxnSNc8drmgLcSemQWYHPtv6tcCPiEs/w0031s4gikk.321003.ts.m3u8?ver=4",
                "https://apd-2ac9a7d20f11a7a553d18959f2614994.v.smtcdns.com/moviets.tc.qq.com/AYP9Zu6KjL4wcV9q5oi6PJreKZDj8ZX9uQjHhBJ3jXAY/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/OK_GkN0S6ksNikaRyDvElopQmTn4s0UjJAeqPkUTsXWc0gNToH5nBSnxDpEQwqEmppY72G7oOwLuHSxjOfskOqPP-a3MQo3Y4l0daa1TNTEfu00t-kR8e_7TJDF6hPED-qlTxBFRCOa7g55gssIDEZRV41RqacOuEz8ef11GVsU/f00313wz0or.321003.ts.m3u8?ver=4",
                "https://apd-f07b0d81a468a7a61f7e8793aa182890.v.smtcdns.com/vipts.tc.qq.com/AqgxgpdWIL_PBDvZBRPZmzZ0OnkWC4AeQslqdkRu8Qww/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/8CrQRbXHgl4MkCTcCEWp7WniZjW5Cz_mNHtp0ROTZqkGMu31tYqi0fGv7ZeiIGoJOItoBCM7nSGwqRKUzxjjoThAqrzoKS8PKKbTLCMaFT4qUC7MyLEqE7Hb_4tZLDkpyZObsREKRgrdNoQibYNYLXOvepP-VoVZioMVAUiPVbM/s00318jxyqt.321003.ts.m3u8?ver=4",
                "https://apd-577f55182431919dba8a3bc723aa69ba.v.smtcdns.com/vipts.tc.qq.com/ANHLMoIi6a_SutJbq1yLGrLf_wRKF40OCKsgZ9gQt79g/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/jre2hc_L-vR0apt34MwAJdP9XZnomfrDSwFq4PouMk8ZANG6CGPkM501dJK5uC6ufCbvFhi-l3rAsbwH43CX7yhQ6f6flJLtw3ibr6VnmguyazKMV7XrtTs8ZUuPiYLQEb3cIyh1AfkMqRxejnEA2HipqLqSHhr4MplJaT8Yssw/e00312k233h.321003.ts.m3u8?ver=4",
                "https://apd-a57feba2995f7705e8c40170ea06f0c6.v.smtcdns.com/vipts.tc.qq.com/A_Is3uw7q201YXHneLwCGHlt-ZMmtyILpn0pRl8bNklw/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/Cf3u8-XB68gUZFbhFV0QHjGSWCuPtc5PlGQzRILQEFeLURmS7GwI-C3YfopoD2rpMVkDF_hmPHyTwGKOBgMPkgHpkMvFSEywT2gY02rK9WXIvdTGD_xkAPjIVnYVFMq0CBE-dlGNnJvyBf-EEQ46FdmRCqsKFUNhFo-3x8ExMAo/u0031yj1nug.321003.ts.m3u8?ver=4",
                "https://apd-ecfb780e126e016c3afdd4f3c5fe93d0.v.smtcdns.com/vipts.tc.qq.com/ASPKa82rZOFoou_eFlCJwPgKkmvKFloXMdVuljx7V7DM/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/PYew8-UnJSEDfF6tHoaMUF8l7ZraSZZOHgaVHNxd6lk_JCKkbcfYBEA-u2bGaQ9OoVf04XwjjvZ82JzB2T13OOe4kSOhore9l-1ZSVD1cuxj2HHucP5q5vI3psVHOFBXXnse1Lo9D-4TGFCi3zg9LgFavtf94k0nxScmrRzcSII/k0031txv1f5.321003.ts.m3u8?ver=4",
                "https://apd-ccae587558f36bc174037b5b1cee7d67.v.smtcdns.com/vipts.tc.qq.com/A6-JJswpdmeTZJLeqUFG2XK5ebR_eXKh_Qe0cJoVRrgQ/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/1sN16EFjWMMtVDZDRcRWE-of7O0MbWKUzTUg9WSjImRaBdk2e_bE0vhV6ieV0MIEI6-a2deA1xf02s1iJ39LPA7kljfdl0p3D-Jaiv7E2sy0azAU-rn6enYt5O03UHx4UorMYDXJwIMZc_3Kj-ROfm3UhyLaTcHDQDe_9i4X9GA/h0031mmt30m.321003.ts.m3u8?ver=4",
                "https://apd-2976ef0b6b2f514b79670d1eb5ba445f.v.smtcdns.com/vipts.tc.qq.com/A_m-F4lcQUD8pQC3wK-7RreHnOuUZgKAIj_8b8sooA4c/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/m-evHzAqU3QqcuenKOTlcjQL-U01Df3IYkrBlsmu6FVxn7O_1FwzcReJvkBeNGQcW2WQ8w6eNUxkE3LUpl9oP3IK-Ob3NRm8lQM6oNYIKd_7shYCZTL4dWeTsoZocOVvUNgdkb9JhIThScUyUnAMZjhqN4vLmPQiHKSsjzPCeUk/m003168l7id.321003.ts.m3u8?ver=4",
                "https://apd-b9f99bded7d04615e5617e1d21c7d2fd.v.smtcdns.com/vipts.tc.qq.com/Ap280nz0TzLpwfO8Jz9lynkpqElVOueS_ZEodZ0AaLyg/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/SPk83LqFeIYL6iAAqhzryh9Qj8lce-ndKvCLTj7wAdOK4TrgwqRio1IToshc2SVu16J0F1D9GGzYw7FjyXz-lx-k55sWeWhuQTw3LxobZH8pIADatfx3JiVCmksh3wEbvJrcR4FJKNoGaEiGSaHKtKFAlZpz4gg3RnKTau8Qllo/i0031w667ao.321003.ts.m3u8?ver=4",
                "https://apd-e06e6bdfc4529f301c646cbb7d1d4bd6.v.smtcdns.com/vipts.tc.qq.com/AkB4FX5KYPVCYTvQKTFOhEMmI079TUosRppHcCw_WOlw/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/O-71ifawan1wIpuTVNyCiCg83JUkXhPoLAkWf_VFFMhMCv3m2uL08SMoCeZysv1S66iXTAJnT-qduoHLKM9DH1NxlrjWw-NLKdluhHG0rqAESuw9hjyoSjhUoIwzqMuw8O0An-NC2HH9F4pgQgttJPsaIfYCALCIiXC7kVriuz4/r00318trm1s.321003.ts.m3u8?ver=4",

                "https://apd-16f6456f0a32de56c3e90ae32c07f8cd.v.smtcdns.com/vipts.tc.qq.com/AVsb2vhW8cj084dIjzNsm0fQn5LIktxg9LrF0xtyFIyI/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/1TN9NqV0oEBDPAy-1bXs3UhloPPlsFQ7iNgZmbgTS5zOmTGqQuElAzIXlAD3IX6J-68Hp5-k9NIdHCkzytVjjoIW97XAoy-Xc_7mlBqlf3qbZMFui0o1InBxIVgIWBrbiLrmrNKIv2dPMSNhyxbswU0w4bdKZ4R0WNjtmXT_Ef4/r00311vm10d.321003.ts.m3u8?ver=4",
                "https://apd-f0612352824f9bb5b9e38f9659a5ee87.v.smtcdns.com/vipts.tc.qq.com/Ad3j8-pSgASVpuwp0ph0bHcpae-S-qO4jJonD74ByvAs/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/WREWKBeO7t6RBoDtJzMUZ8ZUjxWljkJnZcw76CXJjYQMnyHBqJaWX2mzvNLV_mgWIPvMjqbKxOP1nV3utbjHXRd8lTh75TmDjulRwnAdzjjNRC50VOvB-jP-bXr2hwrZoNShj86nUexlmgYNoclqwDah1Bxuaqw5Y-yTFl0QEok/k0031gee0ry.321003.ts.m3u8?ver=4",
                "https://apd-16f6456f0a32de56c3e90ae32c07f8cd.v.smtcdns.com/vipts.tc.qq.com/AEfdm1BtbemsTVLYwIiZ_BlNxTquzPRUnNPB7DPVodIE/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/1q3KT-mjT05Ue_WxtD1peiMfGS0ang5TZjYM_dKHtua2DMa_pqpK8xHaDmnQq7xREP9jtgmgK4MSx6kXd-c7vPUXRhW5ERmIZwT6QOFjBbf93rm4kDyHmaKmiXvWoGBYMpUA1VuJbtsUAWC16m50Rtl3g3G-1_3McFouZ3vN7W0/a0031w9ahzp.321003.ts.m3u8?ver=4",
                "https://apd-ccae587558f36bc174037b5b1cee7d67.v.smtcdns.com/vipts.tc.qq.com/AMnys3E70ioZ7QjpkMV-XehZTBt3jZILvFIi07hx0Emo/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/oXeNi77bxWxl41re86D8-VB8thleNZ-QuFKM_aEeRwqz5SIIXwu7229anik4vkE0bKK_LXAclwfxY09Xi_Xn1_tv-NjhR7-J7sGVI8h61A8WaZgknUjDAGnqJOiVgKXyKBWj8FOBRdzjkc8lWtdcKlK0gIYXVvY9Svo5BUxSqEQ/j0031i8jydq.321003.ts.m3u8?ver=4",
                "https://apd-76ce1d1d1679d7e5bbe86eb869f546ce.v.smtcdns.com/vipts.tc.qq.com/A0Jvp16LMt2MQrv4UJ37V70fK4Mzou1ggt-V8rBPbnD4/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/6gp_EVuUukGDy5hoSn6yKoD9zTUEkkX3OHBVkXXUc6gFAkK4Vy_gwWVAlJA8nCYj6WwtU0UHqJnswtkMSIrnhYGXA3FsWLb-H0YqMB-NNA_WbmhHjW0sy-_j7g-fDc8fdTs-ITOhU13BNJIQfSc1-v5gJ29ekCBtFfb4lUW3yY8/l0031gi4cht.321003.ts.m3u8?ver=4",
                "https://apd-f0612352824f9bb5b9e38f9659a5ee87.v.smtcdns.com/vipts.tc.qq.com/AHiRnGsN7BRrGmJZ6x7d8Ty4vMPT7SB4MxOPSvz-hTQ4/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/zXvtB7Fya9dzhu1D5F6SmK4uHHNEOKTOOvJidAb3U2v3tkKYe8OLbA6nJlq4L1v8ST4Avvl8D9P29iFiLT1LIJcRWVp8ofnLnRV5sLioe3ZimUr7jFG67x0zh17hVq0_HSwjYT5SEsd_X4KKi3soG8NgK96xFPBLeSIrrzLeoJg/l0031cjfafo.321003.ts.m3u8?ver=4",
                "https://apd-b9f99bded7d04615e5617e1d21c7d2fd.v.smtcdns.com/vipts.tc.qq.com/AZwBLicak2DUoaVxY_ZC_hp3Vbtenen-3YHEfFYOzOPg/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/SbO1x20-_kPM9oHO1IhKQhxGnugtBXvAMUVQEeNjoQWTw6c0F_bM0Ztg6VxK1jJJEuOSyewj5H-tXDaBlw70nxNipJYzydooJMOqhfxy5ecfzmCMuoDAI_zj4OiqB69HgdDv3vdGFWsOiTnCQSghfDASiSQbvQ02SYNIJuCZNZo/u0031ga76jp.321003.ts.m3u8?ver=4",
                "https://apd-a6003e35866e192721d4ef426837ca86.v.smtcdns.com/vipts.tc.qq.com/AcStcbh9EOTXPyKx-sgLlYIDXntkCE_yUFUqT4ZKYfGI/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/0q3kdmrz0uvwb5rC2l6Z0euXSU8hIuFYJRK0kNzSRv9ZI6ee_L8T3nyskVQIor4-gBmhYVUR_nya8Pwx1ePgRpxsSMNWK5qWgiMz-yMrv95V_XTOheqkDx3LmUXPhd8TyRWtAj53dLx8HV3JWmQvek5LPqRy_RLThHA7MSn7_WE/n0031dbr2th.321003.ts.m3u8?ver=4",
                "https://apd-ed2fcbfd8ef662f6e248094c5bb8bb7f.v.smtcdns.com/vipts.tc.qq.com/AJPb_38ZTlghLO5ODNeh-DDO_MF7u-T-zZmEPFPlHIog/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/_G4o1JHseBpDJg_4UghMbVVUZ3P1wedwfLCKOLxaXFbbloIgTfhgSB8r96ML-G40_WBu5OpWJUCpn46Nq6pQ1E7EzuCEP0BsNug58wEaew-6NduRvF_kcfKv_gvsXG673P9WYDNNCtaYEp0WHJdEB4Idlj8QYfTCVCqX46fQawQ/o0031sru2es.321003.ts.m3u8?ver=4",
                "https://apd-cfa0c4a15383129fb7656d0a78763e5a.v.smtcdns.com/vipts.tc.qq.com/AU9gCv_tkOWuaxMqnQhvEPirsIEbI6kLgmBPnnQjd6kM/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/OrKpxoCq7v3bLUbhpBS7DGitpgWLITIMQc9zI_jqIoFWdKQYY3c665hipFp8q5aEB8XJDTSDodrLy8_MG-453cNJQGB0t8-g17buvcbAFFwNZcKWtPhO-RRRmoYunmD2tokRN_LmdkOBI58pYooIqGCpkmbyDS1GxJWZSmfz8rw/d0031pyubha.321003.ts.m3u8?ver=4",

                "https://apd-a57feba2995f7705e8c40170ea06f0c6.v.smtcdns.com/vipts.tc.qq.com/Aiu_3xrRrfjf8VTRutn5ctma5cUeCgZOSNOj6yeLqKeU/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/-b3zu5C1x8N0_0YegLYFgyqC0sIaKKP6waDEuevxz34mLplnXSnc1xVv8lxi4enhdNsubgl85hzgtF9NQOSVhN_cDkCoEGckGiZ7JapX71h5rLLANILtS4lF8hkNqv2hZ56Iic02JSM4aC50eZCqSBMQRKvvGhaQupeoqjtqjj4/o0031pqxcn6.321003.ts.m3u8?ver=4",
                "https://apd-16f6456f0a32de56c3e90ae32c07f8cd.v.smtcdns.com/vipts.tc.qq.com/AvizBmiDbOKSyV_9-GbRU7ow_nc6WuGr5U2IOUWVsiq0/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/jS9fWFbzMilH4WmRFmoES3du7B49zhtLrbO1WXT1_hkvatRm7wT_xH8LnXZK3xJw9FnhaU01HAwJG_95w9HW1NBgUfh6ff6xgIN6Ca3yFD5iTIkKDkX3VNXch6DXpo7rkxILeh5jIvh3WWvBW81gYH8IAAEd-pl1I9bVcsneL9Q/d00316bjh89.321003.ts.m3u8?ver=4",
                "https://apd-ab28416cf26b7bcc2ec925496d51da67.v.smtcdns.com/vipts.tc.qq.com/Atsce6NmIgaoQF0-uy8l8jPHw8GBEwDupQGZe2tOhw8M/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/X_Zun8FH2SCBtaJzwY_Fj7N0YMrNDhygJiMTqBKYbGeDwzsAg1ESlObxsYGmwY03zjcyY3TLAUQUX5_Godf0IrkV7Ovhwn20m_RlScUibiBqRYWVnRp1UNOT9ee1CIWzcjIWtI7r18nP148YEbnde43qlkeMx8BAW9GXP_9KNDY/v0031zznflx.321003.ts.m3u8?ver=4",
                "https://apd-e6f9eb8587a474c381a814e847cf62c6.v.smtcdns.com/vipts.tc.qq.com/Al1jiFaVhoSH02wtThxfEO3WInDwDJdv5zPwcNpeM3GU/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/PqiEOUT-W1glDnGVu0XLoTVeQ6ZmUAkRUgEgvE4yc-tQ51RTi0lWP5OAlYIo2DtuXXT2Ymo5TBzxkHPDmunrc8XtXHzqUsTJaxSzPsMf8TgS7HEna8woFiOD7IKr8mtulrhdvjU8cpHrOQ8bROVe4NrEewMWxT0X5uDm0i-E3wk/z0031dzmw5j.321003.ts.m3u8?ver=4",
                "https://apd-c3adff0342f8febb05616e08e7975fca.v.smtcdns.com/vipts.tc.qq.com/A_RGbElhZ6FWvBHCcsliBaAFtmJyr0MBcl0W-ZZgD0Uw/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/wA9kBnb8BrBZznaYQbeywByF1ZPyDDOAcMYTf7ghZcvCO2dFcQRW7oUf2t_82m-ldve-g5ScHk2hl-z33Vi-LfIyVIRK0EPpn_wpuWsNNpqfhj7VTQw0ASFZUeKVrSE7IBDfWpsvDD0fep0o7iuJsOj6QFv9zb0Hv0PFw7Acwlg/y003161r0xb.321003.ts.m3u8?ver=4",
                "https://apd-b48ef8d80ddc7c141dd825c7b6e843ef.v.smtcdns.com/vipts.tc.qq.com/ARhBfJjTur-_hdvi7tR5I1MYcITJL6HxFJ2uL31vcnNY/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/S7z5BEO7UswrgicXGes1hKiv8pqiZFcCMmkQy-DYpSh6b14RDHa0Z-iPe3i5oSRFxBlM3yim6Jhfk4Y9sSdyvrUSrtpGwycMykze6qm4CnO8Srf4JbW2WMJcLXWyeG-K5JSNGHVQWkZQT0NHWNUUQu0xalMKTD9H2hToqtT1WXg/x0031ucrwvr.321003.ts.m3u8?ver=4",
                "https://apd-99c44566ac814080d551f5848fdbacfc.v.smtcdns.com/vipts.tc.qq.com/AL3Qvx1JWnBFW8D1gwXlSwlSG4OectbZxpZxWg4zLSqM/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/VmeRNs9cFmG6qLyzKHpzJlCRfb6NWC3I6LUY4sJUpfCNHcq40cOhhXNBaXLsJvZbxHk3_cb-gkHSkR2e9yXdvcNVgUbpDbvYM52Ahn9whKJr7U9oyZdCJZvr47jJM0OaYqgIJ9FPJU009zYmHyfhEOm8Xp9y1bhso4dgSbstYFo/j0031mk6uig.321003.ts.m3u8?ver=4",
                "https://apd-1dcbef79484572b5aee4d6cc3297d014.v.smtcdns.com/vipts.tc.qq.com/A1GmPz57YR5mCwfokYH0u4NSfv_WrFEYcNnUtF_p0g1I/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/sVkkyj1MMD-kFrwyB5SCaroAYS3hTIHFZm8pcmKNeii3Ym0HcIYzrAAQnnWViRybjbhlTHLzM_hkLm6p7T_uY2BeHQFu4kDyBoqAq63ws9mfkI6j44rZusNWWAatkxiwz8DkC47z6nQvOutE4bnTd05LpSASDdLWscInJVG-0zw/d00319bhdau.321003.ts.m3u8?ver=4",
                "https://apd-ccae587558f36bc174037b5b1cee7d67.v.smtcdns.com/vipts.tc.qq.com/AqdrRUV-bl2G8sTzIwc8NOBvwrapr8fk0I8nGLIsWnJs/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/ElJl8bvFdb1pNgSpQPOsAdLJfp0gOh2Iz-tkNJukxwUChLzKCSfX62KjNOw1tikadT_tqVdgl97_9iGH4aAkOIgveKPSwDNCdX78_DbfzyY77gJqegdw9wALXajKFBY-gDSOF1cA8xFV3syfON5DJ774EZrYCntSzf3JIvdV-V8/h00310cpwm2.321003.ts.m3u8?ver=4",
                "https://apd-24524947f5e36f361636cf5199994762.v.smtcdns.com/vipts.tc.qq.com/AvfWXvveDdqurZc1bXV2AjIYUxn7YXPmL6KCKLBvKQjY/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/_QmUeA7xbaHkaJ4hcj943g9WY0PgEQAsd8rbYYB8F1v81bTXbkqXSQr_JXt9abDBudTY0YLkrJC0QFmbi6Pdi-Aa1fZe1Mtc-SccIEkXC38GkL2wHRxTm_BSBuQaUTdvr0RSyio_9Yw-v3g0jLL9ESRChH6qXxpAGCBtzSjSqag/o00318mbqug.321003.ts.m3u8?ver=4",


                "https://apd-76ce1d1d1679d7e5bbe86eb869f546ce.v.smtcdns.com/vipts.tc.qq.com/ALGSHHQxs0caD8gy0JNTeyEuUUVB42c10nCBE9voXCNU/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/Sf59VhYTo0WbrHXqyfb9Q5XOGV7UnT_SdAjv9S5zwsr_s2mSIy3Hcelr_oOg5MZYxQNH6Ay4-9ZfX0hfGZBcDSEuuHYH2aiQbkWMgLxUj2HAjr4XE50O1QgwG-Z0B8nhpKlrNp3JCqCsmfclGg_7hTmH5H9WkOpnJt3nkrV7ekg/h003168132m.321003.ts.m3u8?ver=4",
                "https://apd-435e6267a662868386a4b3b8acb9678a.v.smtcdns.com/vipts.tc.qq.com/ANLoK_3-tSYF-RaaCiO8MIAmQMC-V-JUnZQFi4Q5ZjgY/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/fpkaoqECJBZeUcaHX0yd5URjekl-jawW5aEjF4XFOUiKxDIN3B1qtx0Ili0WAQykvpD9tzr5Se0GpeXg4sDnnT2bnOUiW6jnQ_ETEyePXC0btSh43dzYxZi7gD8nzQYTBj19xzVCr5EtNUmNrfWKi-QraqwDGJuXcmVwKDsWoRc/x0031ck9o8i.321003.ts.m3u8?ver=4",
                "https://apd-978f37b4f32b9b49beccb5fdb31145d4.v.smtcdns.com/vipts.tc.qq.com/Aqe-3q_D1WEYflmNZHJzp-kVnClKAHDiYos433ALUKR4/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/GAQz1BGkDKHW_J8WR9FjuVjtcJEZjgdCSiIRjP5MzDUl7CqLLPAw-72470jrdszspcHcEFVHJVwyBsYWBWHXEzNyGG53i2GFOnjT8fH1RGHMC8Qyqq4DUuLjb4qq0ZLA3Kb4MAGvxA01pd4NPxRiIzgkb1xANpE-qoWHAmeJZf4/d0031plwgy2.321003.ts.m3u8?ver=4",
                "https://apd-ed2fcbfd8ef662f6e248094c5bb8bb7f.v.smtcdns.com/vipts.tc.qq.com/ARszlpsHjCm-GI-BZvK1Z4qaQD8ZUOTqTVLh3tFsH4TU/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/Iguhcmtv5ik8PRxg4XshOJwtJwkTj72L2Jr-xorQ_BK1EWU5ftB5FSnVMrxUWcyeo0OZG1QaGppfHXds4UtHic26E9BYlHjXj3iwSSWgOtdB6xDRjefG44GyeFDctDSsMwC3zdHtKi_P-zovlaIBnnNsKKeq9itySfbccLBuX6E/a0031fror7v.321003.ts.m3u8?ver=4",
                "https://apd-26b1f6828716b781340e0db860cf60a8.v.smtcdns.com/vipts.tc.qq.com/Aaz5VcwMKZEkBFd2PS0lLsKTcx2ivqvizm_M3PQ05PPc/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/9Cz6A1vz34PqUZcRBlxvDNlDq17qQecF9ygC-MuLBstxJnGPGBdf1aMr1rUG7DwAKje5hl2t9nxegQTf92jSlclfKOkekfzKtbCYJ6Vje-foMwxEZB8qDDvmVlWUTBfq-1hIqCZIC8d33fHc7Be_9NZT6sXtzeX-a1xIqOloSYg/m00318dx966.321003.ts.m3u8?ver=4",
                "https://apd-e6f9eb8587a474c381a814e847cf62c6.v.smtcdns.com/vipts.tc.qq.com/Ag9Ifl426nakwlSg7zvJtPV9wMJ71UG1BqUI42phfDrc/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/MRrCtZ_ZuYmEsOvM-CaVfj63czEg4yK7OVJ94hc_ktnLVh7tbpU8nuycuwh_p0DeLXqmcdI5O1zGojaItcOe2XuUj4Tfkb1nUk6TGpsq5hV73fiGFTAcEOC67DIwpXXqBkE3CGgTUIzJlFVwWp6RY-5ehBSUL2SPq-tzn5HaL5A/f0031b4317z.321003.ts.m3u8?ver=4",
                "https://apd-f0612352824f9bb5b9e38f9659a5ee87.v.smtcdns.com/vipts.tc.qq.com/Ac_5YkKJeRTarkvSo1BRc5KKfqzD4p_taKsQk8136ckI/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/KeCz4gnB2rvugKvzuFb3T26fOBXbDTyh6NK5fjpDk7mLL01EB5Voq2iagZwxrPxK-cK0he0_twOrvjaTh2AmGEPqYDRpiSgbTH7KVdhtcK4kIUF-Jhlq-ovmDC0cFpzn02kridWCTierUEDmMBfu9beC-QP8nlvLzVdy6_06KlU/a0031jhnpv5.321003.ts.m3u8?ver=4",
                "https://apd-b2e2f9acd6329c1c7542bea86b213ea4.v.smtcdns.com/vipts.tc.qq.com/A8S2nvFQvH0pm5KaKPoUDFqMwJ2fk2YWVkGdISm1KP0I/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/_5e51dOBnTzD5F8tLNQEzYyvpa3_x6T29xJGlggV6avws3L6rbM6n563ZRh0_FGB1WuyOiEoVjHk2MDPvp-HwGJGBizqFVJ_TTfb2xSq3PX7w2xD-l2tRU4_TcTYides5Ps1gq50VLted9PQeuhMwNbMS5qgNUZq8NfuhW_9lOQ/w00313yqwtb.321003.ts.m3u8?ver=4",
                "https://apd-76ce1d1d1679d7e5bbe86eb869f546ce.v.smtcdns.com/vipts.tc.qq.com/A-i-iiH3CmtraYUmGOUDQgp8yRm8aVI5jUoWWvdNM4ZU/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/dpJF-7ENnGtaG-VEG9l6ZvKUGWwos4WzZf-Qxglw8RcCgroxfodTmPK03DLCEvul0C2Q60zEHt2oMMsg64HINR1ixxDHIZldRR_NSuggt576T7vN6OW4Hm7pPj8bHJRXjnyCNqVk69IujCxfqwFevT9FBkAl0dyzvMpb5qTHoZ8/m0031msfa8l.321003.ts.m3u8?ver=4",
                "https://apd-26b1f6828716b781340e0db860cf60a8.v.smtcdns.com/vipts.tc.qq.com/ALGSCgJL3MwheMUn9uUKBwlS09Blucf0vo2-gO3M5lDA/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/47iaYRf921d0pzU2d93X1Jz1kRGA9JdWti6lIB14zlHezLp4xwRufd5bq2wg993JdYY2f1u5WzWk2Uq4o7IAESNU4i3qZGOWJ8XMp2GfHQVL0XBOUqdmRhdGJiAPD2vmcc4cq6mPtheK0lnoAs7fKIsyZuJULjaUi0NhOPhZZ90/c0031ytvpma.321003.ts.m3u8?ver=4",

                "https://apd-8f82bc4bd342e5bd60fda516aa9dcde4.v.smtcdns.com/vipts.tc.qq.com/A7uVYIafR9JlQPDzVZpR4KZ1AcIGGmdf7bxK1cuuVEq0/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/fjVmslxZ_Ts4Ucid_y8ylY7RGErEgzzXGhkfIYQ_t2pUNZSggYbU1BWb8d-PDO24zTIH5QEqVyfLKQKDOmwn5BLC5rto6GReRj_Imx0TSRbsXcKu4uz70bQ8cHhMemAHVb-8VFPrECNslu2erXai77LqM9jFQk6tIaIhbIJIRSA/i0031kf4tti.321003.ts.m3u8?ver=4",
                "https://apd-61fa78dee78d08cfa6a7b2e0c4b31d6e.v.smtcdns.com/vipts.tc.qq.com/A1gtm-1GMCtwmLp-IvmPAbwyfugdRFQtNVCcHhjoaB34/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/ihDZePsTIKZbyal8_2seJ4nTsYTAHlNM_NRgBrC4tQvKYoleyXc0WtN3JkxSQmFQzaiQCl6Hg9O9TlVZkD9suy83seBLfOI_EW8fuIugaHJHU5GgcRF0KQX12237emfoWBOMQdBbj-u5fZHVcg7vHmgmTr_NwJvqAHnWtNKXBmM/u00313z89hd.321003.ts.m3u8?ver=4",
                "https://apd-e06e6bdfc4529f301c646cbb7d1d4bd6.v.smtcdns.com/vipts.tc.qq.com/AkGmf27hhx64cD3rT27zszniQUAZx7EDzO0trFJNnCyo/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/4df2F2S7Kkef8aAWcNYCazTlkun_xNn8Tk-c8-GOOy8Dn3h0XT4V_J-JxDJ0Jaf_Bac9c582Z2ldBsInMu4rUf1cxe7zX9FafiXmeq3PMVcslooYf02rVhzS3YaZYsSkxgHRYu-HNEU6YJQblR27obdvysvpJIayI4lhlQ6nPo8/y0031cfjc66.321003.ts.m3u8?ver=4",
                "https://apd-4e4067e802f87597472e6daf727aabd6.v.smtcdns.com/vipts.tc.qq.com/ATizsZLElJxS89n-8ptTY0bJBEdpt4pfVmOeEiA29pUY/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/uhOhcki-LqOdWom0chAWCMpCRN1b_4BA4JkIQ5cneGUfA6XcmU7mXDl3zV-o8kISAejqnCFjnu5o-sS6dCmYMwz8HZPG9QXVWmImjgHF6qYcfjYurHkh5oRfjYYj041UbEouAe1KFSG2nmEkRUfvgMXVN9hSNdWq9tbUvHX_49g/i0031cfk9ud.321003.ts.m3u8?ver=4"
        };

        String[] mdzs = {
                "https://apd-978e5a6f17a17a3947eb9fac0282c50c.v.smtcdns.com/moviets.tc.qq.com/A_zWaMh0sUVCs1YKePidlFlARIBYh7z3p5Nh6ChvtL9w/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/xXc_1F9O_9NmGyJ4rGmNIiCZJQtXHkEDYcKpIqDw4MfhZZXS93I5BX-ylZPDr0oAAJwIEJkhn3xjebSc2zqeN6A8PLG6wc-eOgqH0VbbBRZ_4_AAIA4tQHGbfre1SDeWBVlz1_sgnYEW5b7CPeqq93oqCNucmsTBM-MNRPlK1Qk/g0032mnxspv.321003.ts.m3u8?ver=4",
                "https://apd-e6f9eb8587a474c381a814e847cf62c6.v.smtcdns.com/vipts.tc.qq.com/A3g5s_WfEWjrAJLhkBb8Meuvf43A3uGx08I1OG54a-PA/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/bHSssKFdSnHQnuzZlw3WsSVjTfBt8adwoVswNam1479z61T6JADHHQI6kysVvsrqsG7qzUpkBZHJ352FgApo5k5wCfc073ovm8RNkA3Di9E8byF3dqMqiNZNEABryUuk8AY0uEvZhB6XioYN1Koe1FJFdf02NUcqbKSX8Q_x0Zc/c0032xbj3cw.321003.ts.m3u8?ver=4",
                "https://apd-ed072fabe35835d44482c8ff26ad3bae.v.smtcdns.com/vipts.tc.qq.com/A2jmYYgq9GbjXuAc0HQh--tyoDjcZKdWoWvMJD_Nh74o/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/DXHsxfOiZN0cpu1z7ENFVkT3rEgOrvcJXUKNCrAmT_Virq15wvLHTmk1WsjYMn2dggdR8YRK1byDYiVimgEyrdt0vaDKBylnZaFMnL--KyIpGL4VSi4Z2cm5dY8Ydo0NX8Op4bTUJJZunfT67Bgg0-zLj2hjHxnU2k4TfR5a0Yk/v0032dyt47e.321003.ts.m3u8?ver=4",
                "https://apd-16f6456f0a32de56c3e90ae32c07f8cd.v.smtcdns.com/vipts.tc.qq.com/A8gM18fMbH5ok5SUPXbbZkMHPYN9GqzQc5P8DGcCC2wY/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/JvjfdycTuGjkF1g28jHhmQCHDhOuRoS6XOLbsm4Z7WegLYQBWvEHb8mrP-b6SfVN5PEo_ymoAbInWAMmW6t84ipp43cYu08ZE7K8hnN7lhA-axzCwEfdl5SHUV84cviSJ71O3QyxvjYCxpQB2RTERr4I0GA5eHuvf-tL5eY0SgQ/z00327ql9yl.321003.ts.m3u8?ver=4",
                "https://apd-dc67c8b1807563b45db631a313cd95dd.v.smtcdns.com/vipts.tc.qq.com/Amip6Bn0mhIYiTFqxsssUBu1yNthSB22nYcCUgraspzE/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/4Pf5J2aT2Z4affKF--APFI9z8VVt1-A-CoPoet5-mGztaWVGsK6KwRm8H0u54vWUPuLtD5xupLyjlebJHH6diiDBCnFxhfD_0Y0KLfOypX64jkrWBI9XHwwN2vVeq99-DCbSqYEQ2s5Emj-cGKsJKq5SIGWHVIvkm9ln-trjDBo/z0032k1719t.321003.ts.m3u8?ver=4",
                "https://apd-b2e2f9acd6329c1c7542bea86b213ea4.v.smtcdns.com/vipts.tc.qq.com/AvyI1D1bVD8dFLMGdI4wvK9ApZJYIec6RpBwe7MFZnCg/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/GbxeWLEIZ_rtFh-NG-5e-JZELaqeynPW6oVqKkkJII0-NOMgIyVn7nTBXQAopRRoHBKM6RK9s_Gn_0MO4zYoSZVjFefTmZd6Zr9aAed2abNRFDTtDJC6uT0byEUt18B-v9lu08lUiqwtFmTX_Ng1PAg1Kwj2BPB_qC-0-R8WxsA/q003200yveq.321003.ts.m3u8?ver=4",
                "https://apd-ed0dc164b117170f7f9313287bb28156.v.smtcdns.com/vipts.tc.qq.com/AezSfpnU8d8RUX0a_GFP8TjQVO5M6O-9aQgvgfb0c-38/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/lUKT8EoiH8v08bzU4xoboN67pWIJpOvUc5b-9L8WFODwBFEORwULQJE-lB7vSQxRmJnrUT-Leve2FK4HI6RYRJrMk7XqBrLULh7n3tV98xkVAjQZh4YpwL-5ZeCdzp3pkAJZ8iuaEvKXPIXKZ9yoTsGPLOajualHg4fNrE7z6q8/g0032zckzen.321003.ts.m3u8?ver=4",
                "https://apd-ed2fcbfd8ef662f6e248094c5bb8bb7f.v.smtcdns.com/vipts.tc.qq.com/AiUH99onas9HQnHCcHLujsyydS34qXNXs7bDT7YOEwLA/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/GrWoF9rEWsklODGUNViDGvJ3r_nap6DjvHCpJ21VjlIDh3BwHU-GybDq9dXVDK3AEMWF9otkYYdJ4QwGT8OBnBC_88OrU9OHIJFbdAebvZF9iR1hAPWFfz6CU8_gFGt2jgsbOCsKe79yC32g0yAQHo4oZuvr3qhVyoXbVXi0EM4/e0032tyqa94.321003.ts.m3u8?ver=4",
                "https://apd-2976ef0b6b2f514b79670d1eb5ba445f.v.smtcdns.com/vipts.tc.qq.com/AtrWv9czRAePIvzU0824Jw1Wtas_UcakgbWxQ2P16Vbw/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/w0FPlOCIrK1N_6Gd64YuTyVwySmDljOElDlrssL_nshXh7LexxrIqOfTpDVlztWW8-WM2HtDJAkEBN5rAMrboZcquuS-ZuZEVEcgmOBAuHN1YP0J5A25feAngGV3-BwqroIBXvaVvc3CLHHrG46bAZHZerrGRIcozxdMwBQlem0/b00327669w6.321003.ts.m3u8?ver=4",
                "https://apd-03395faa5fa9bdb9bc2fb132372d61c6.v.smtcdns.com/vipts.tc.qq.com/ATG5RSnMk5nBmrJ3M7SyDDV2FKcrpkveifE7XW-UIFdw/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/Kkp0AfwN2ZrK4YP6kpvGLiOJIonqjrLc5Btbw_LorBfwyGiRfTKk4FPwXD33dYNhHl3JgZhCVS8U-dtxKwjN94-HuevwO8BrQudHZsl1vHiicsEXe520qBgkB8xWcT3L7tjT3b9rh0GrQZHldDQxzoPoQyPQB-4EmhxKDHDVoQo/h0032dkkuby.321003.ts.m3u8?ver=4",
                "https://apd-6da91c2f357b2e6d03c9163268c647d6.v.smtcdns.com/vipts.tc.qq.com/ANZ9LkpFhuF07v6HIQPHpkTs7Sb8ypuTNgHtjDP-du0U/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/e05hgHcWufIZqwTslrEfw6YQc0yi0uwuL25aJWFzCsXKGHnOxMYcYtcsuEFaI87uLmKVmQuUXRUbvntc9ebl-eGETG0IyvBlbTRmk9wmdpYkIurTAy5u3VXGJDBYglNDFoD9qrXh7be79QprQXMoGe6IFmBsYg6TDjV1YR63Azo/h0032pmyboa.321003.ts.m3u8?ver=4",
                "https://apd-b5e4873d0c707656acc7a5da24d5446c.v.smtcdns.com/vipts.tc.qq.com/Am26EyxEn9p3UfsoGtDPMGpoyiBY2OPR2Oi2r7lXhAWw/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/U32P9Nlp2sdOb5NFG7cYko0ugukVR17Bem74zF5XZFsAyvVtd7TIJq2fRo-3I8ZvMeuYB6kQtmVJ8DttXtJ-7NzT8tOenTccMDolM75ynCafz-Bg7ebNcB2DABIskBcjBwZNlSSyt6pwu7rKXoRSER2DorYPlIjrlKYMpEQNviU/e0032oc1fhk.321003.ts.m3u8?ver=4",
                "https://apd-b9f99bded7d04615e5617e1d21c7d2fd.v.smtcdns.com/vipts.tc.qq.com/A4rLOlDi__zs6zgWQTGmkMRqJWAkPD46l2EsHOROxrMY/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/ik5_MlzNdC3-HYlmXHG2mcnMcZcdud0ombsJmXwN6BDYjeFL1z0OBzTU6mlygIjXWs7_S6lRjNStT-WOM4D7CU8okrDXTXQa1eYooP3Rd6S6BBFS0Y7K_9awcJuT3dW-U1sRvU1JG9vBLulF6i0Y8j7PP3FFhWeNImpVyCi2IhE/x0032b7l95z.321003.ts.m3u8?ver=4",
                "https://apd-51bfe102585122d1e0f3efd015e03582.v.smtcdns.com/vipts.tc.qq.com/AA2GxhJejTBHpBdu0NqKg1I5BgHaiWyipzLt2nQECjyk/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/sdhoyAAIfjqmOlyenF2eED2Zqk8e88seXbFAF23M8VjZzVFZTkejq9YHNFRW-nCUU2r6etErcDhPsdpLKxLMPlROMkh_iZ5-9Z5TDMnxua8CrBA4UnXmy3GYVlEBerRUI1qOBJKtugwOLGRxcl5SnSZkwBIOy8wEjBTke_8h5Sg/m0032w395m2.321003.ts.m3u8?ver=4",
                "https://apd-26b1f6828716b781340e0db860cf60a8.v.smtcdns.com/vipts.tc.qq.com/Awymch2HoaPh1KEKMFsBfH1__2QNsSRtU5cBGecxz2w8/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/Z_2_A3qmqhOyTCxTl7gWcAE4ZwUSydJ8lErNdFNtYRsa9lu7aABdgLrZOO7-DifP6yc62a3vhnueNYmAvDKnoHgKO7CgeoEcdzo1cJxBequE2YjV1v1uw1cyl_EIlOB7QBlzZSHULQX7V5AJl-bj2VFJZYfdy_eY4A-zOBAnFeo/k003286vp1r.321003.ts.m3u8?ver=4",
                "https://apd-435e6267a662868386a4b3b8acb9678a.v.smtcdns.com/vipts.tc.qq.com/AxjxWPZBuj5VK6-f8oB2LU_ze3ywTSPVhi1pf1qBYoxc/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/PgVidMrt1gDD7aCKPZqoyTnEpAkSTG36SXT1CYvfLpqnggGa-gH6LpKr3Ub6B8BylV6XvGKcDwzBUkf135SjTIhzAEqUuw1gRQUm_-Albaq4Gd1qkggvVV5mcpFIjwog4SNtyCSnrEpXXJW74XdXmIFLgZy8ccSHTmuJt1hwKbU/s0031mbhnyk.321003.ts.m3u8?ver=4",
                "https://apd-51bfe102585122d1e0f3efd015e03582.v.smtcdns.com/vipts.tc.qq.com/A-vcC2EZXUs2cuWerwQlrlO9HCufIUvcCWk6UR3EcZy0/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/pWN3NHRBNyJIrZRgYXHc7Mf6c-ViKEhgIYtHhnotEXMl10QvA6XYtXoUfUwNQx0-9d3CKHtFyKqQzq80_SZRqNy_mZcF_9AQqzrxLwNYSO9KfjYbn5-F2dfokorhxZZBQikCSGa6pIcVoWkz5a_D7oL84PutRuflAiDCPA5NT-Y/x0031l3cokb.321003.ts.m3u8?ver=4",
                "https://apd-77057c8c3263750f8c16eb477c647d0e.v.smtcdns.com/vipts.tc.qq.com/A3kAtCVIau1YakTJiWfOXxpcz2QT31UgFEMCl4K5VSDQ/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/8oI18oAeNHHar64ykRcVZbAuKxNW6tFqwlCbSV31P9hKVJH4oxqAb0AzBRtiQYrh-HXyL6sK2jLVt671j0QupQ0afpOD1HvkuNnm-W6RBQrvy1HTFeAzyiLHI3EBHJFxCOTd8CbzA1isXK0Xnhv7EeRfUh5pbgeYkVLG2wFxIQg/e00318y1l3r.321003.ts.m3u8?ver=4",
                "https://apd-e6f9eb8587a474c381a814e847cf62c6.v.smtcdns.com/vipts.tc.qq.com/APDT6Vm5DEFxxRmlC-3PWS5SFO4zMhXQqjd6tp7AhUrc/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/linIeIegeZxVT5gq7HR6UbZhliQszqYA1wR8NkoSn9mh3sUYzf4cFMUBn5OzPR84ziQ7bMOKmnHcfrB-vl5gcfzarEHHdsf93huvU4j2K6ePiW2-opFpS2joc1K8vkufQZu5pw6FeXFUFDKsmaYwThggXphUjB9lHoiWT2TA36g/c0031ev3seh.321003.ts.m3u8?ver=4",
                "https://apd-9304f6af5346552420494854ce6a900d.v.smtcdns.com/vipts.tc.qq.com/AeeXUTwKxc_rMAndYiinuV-SOWXoGBlwlGMi7sg9V9xA/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/ggVK8VtDXRWvFtohb6fJnqPHQtbvc7oO-OMYJZ8LzpkeUt7JSlprD9zGvOgR2WvL7ff2CdQxuELCl-HBgR6gP4EQjVDWjXiBFSyQISNByYxYLPyF-7UnWNP_0cH1dNy3t2GfuZUZLwUO-zz9HJ8JP4xThXI8DzsCsiborlrYK-8/d00318shrr1.321003.ts.m3u8?ver=4",
                "https://apd-6da91c2f357b2e6d03c9163268c647d6.v.smtcdns.com/vipts.tc.qq.com/Az5QwG5nZRC45al1j7gHTZs8RcXFStveo--t_0jmkk_4/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/ni8K3obO9BeoMAXs8AmL0ra4EgVtEyj1BMpdahRNx81TR2bJOt65SEMPkbqSgKQpf1F2puMtpYnRwD_5RqySLGZJwIZcDBg0KJFapN26Hhke96smDWbeqgVZb6sESI_1ZZlGfAWjE4NjH0zg-j_o8fInxDjcMmuVp4XEdSmTVN0/y0031hk6yxl.321003.ts.m3u8?ver=4",
                "https://apd-ed0dc164b117170f7f9313287bb28156.v.smtcdns.com/vipts.tc.qq.com/AUEOakl2hV5uG_gWV8c3Z-eTqiLtW49mDWqKnBoRu_aQ/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/fJbO8Tcnco-wckISiZqLTXNNh-kNHC3BUCEeOeW8Cj2hz2aUVo_qHlfRjajQzpv1N5EQ76xh7HpIb_TieEiDQPVQXtNwnzPS8g8Z6WiV_ErthM20Hm3i9HOdbsVxkEmIV_7Lc0g0HYDmfDWa-yApJxuTIaHataRKEvvZVBgZtKE/b0031sjobsz.321003.ts.m3u8?ver=4",
                "https://apd-f0612352824f9bb5b9e38f9659a5ee87.v.smtcdns.com/vipts.tc.qq.com/A3KY9iIyUt6EcDI6w6U5dwlq8Sy7ec_hM1VvRa_4ZbHw/uwMROfz2r5xgoaQXGdGnC2df64_gcR4DH6oNabw6qBdCnk2E/uuRCrsuvLrtxUS6fLpf3Df7-X6Q0FqUNeaS753RnmgRKiTOdOxvWOWOjezIcr45GFYrfaAh5yThP73yiDCo9b06rO7IXvLQKBvB9__O6HbJcJVhc7xwZXa5fOMEAF6Dd6ZxDiAh2bRVH4ups6xGEMqXlHrKGhWAgjMwaRhe2fR0/n0032x914iy.321003.ts.m3u8?ver=4"
        };

        OnlineM3U8 m3u8 = new OnlineM3U8();
        String dir = "E:/mdzs";
        for (int i=0; i<mdzs.length; i++) {
            Integer section = i+1;
            try {
                String m3u8Path = mdzs[i];
                String fileName = m3u8.getFileName(m3u8Path);
                String filePath = m3u8.downloadM3U8FromLine(m3u8Path,dir+"\\m3u8",fileName);
                //读取解析m3u8文件，拼接url
                String tsPrePath  = m3u8.getTsPrePath(m3u8Path);
                List<String> tsUrls = m3u8.getTSUrlList(filePath,tsPrePath);
                //下载TS文件
                String tsPath = dir+"\\mp4";
                String tsFileName = "魔道祖师_"+section+".mp4";
                m3u8.downloadTs(tsUrls,tsPath,tsFileName);
                System.out.println("--------------------第" + section +"集下载成功！--------------------");
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println("--------------------第" + section +"集下载错误！--------------------");
            }

        }
    }

}
