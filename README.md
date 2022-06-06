# spring-backend-DK-market
# BACK
Spring, React 사용 당근마켓 클론코딩

###### lecture : DK-opensource SW
###### backend developer : 32183490 이정우, 32197330 손명진

# API 설계

Users

기능 | Method | Url | Return
:--: | :--: | :--: | :--:
회원가입 | POST | /user/signup | Users
로그인 | POST | /user/signin | Users
로그아웃 | POST | /user/logout | String(userId)
현재 로그인한 유저 | GET | /user/current | Users

<br><br>

Goods

기능 | Method | Url | Return
:--: | :--: | :--: | :--:
전체 상품 조회 | GET | /goodsList | List<Goods>
특정 상품 조회 | GET | /goods/{goodsId} | Goods
(로그인한 채로) 상품 등록 | POST | /goods/create | Goods
(로그인한 채로) 상품 정보 수정 | PUT | /goods/{goodsId}/edit | Goods
(로그인한 채로) 상품 판매 여부 수정 | PUT | /goods/{goodsId}/edit/status | Goods
(로그인한 채로) 상품 삭제 | DELETE | /goods/{goodsId}/remove | -

<br><br>

WatchList

기능 | Method | Url | Return
:--: | :--: | :--: | :--:
(로그인한 채로) 관심상품 등록 | POST | /watch/lists/{goodsId} | Goods
(로그인한 채로) 관심상품 전체 출력 | GET | /watch/lists | List<Goods>

