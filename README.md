# spring-backend-DK-market
# BACK
Spring, React 사용 당근마켓 클론코딩

###### lecture : DK-opensource SW
###### backend developer : 32183490 이정우, 32197330 손명진

# API 설계

Users 회원정보 테이블

기능 | Method | Url | Return
:--: | :--: | :--: | :--:
회원가입 | POST | /user/signup | Users
로그인 | POST | /user/signin | Users
로그아웃 | POST | /user/logout | String(userId)
현재 로그인한 유저 | GET | /user/current | Users

<br><br>

Goods 상품목록 테이블

사전 로그인 필요 여부 | 기능 | Method | Url | Return
:--: | :--: | :--: | :--: | :--:
X | 전체 상품 조회 | GET | /goodsList | List<Goods>
X | 특정 상품 조회 | GET | /goods/{goodsId} | Goods
O | 상품 등록 | POST | /goods/create | Goods
O | 상품 정보 수정 | PUT | /goods/{goodsId}/edit | Goods
O | 상품 판매 여부 수정 | PUT | /goods/{goodsId}/edit/status | Goods
O | 상품 삭제 | DELETE | /goods/{goodsId}/remove | -

<br><br>

WatchList (유저별) 관심상품목록 테이블

사전 로그인 필요 여부 | 기능 | Method | Url | Return
:--: | :--: | :--: | :--: | :--:
O | 관심상품 등록 | POST | /watch/lists/{goodsId} | Goods
O | 관심상품 전체 출력 | GET | /watch/lists | List<Goods>

<br><br>

Deal (유저간) 거래목록 테이블

기능 | Method | Url | Return
:--: | :--: | :--: | :--:
거래 생성 | POST | /deal/create | Deal
거래 목록 전체 출력 | GET | /deal | List<Deal>
하나의 거래 출력 | GET | /deal/{dealId} | Deal
거래 삭제 | DELETE | /deal/{dealId} | -
