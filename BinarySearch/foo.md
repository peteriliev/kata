# All Findings — app_cssuite Security Audit

**Total:** 140 findings across 8 phases  
**Audit date:** 2026-04-19  
**Source files:** `security-audit/findings/02-config.md` through `08-cross-cartridge.md`

---

## Critical (20)

| ID | Phase | File:line | Category | Summary |
|---|---|---|---|---|
| SC-01 | 06 | `scripts/customer/SearchCustomer.ds:54–59` | Query Injection | `searchProfiles()` query built by concatenation from 5+ user-supplied fields — no parameterized queries |
| SC-02 | 06 | `scripts/order/SearchOrders.ds:62` | Query Injection | `searchOrder("orderNo = '" + pdict.orderNo + "'")` — direct orderNo concatenation |
| SC-03 | 06 | `scripts/order/SearchOrders.ds:69–86` | Query Injection | Main order query built from 12+ user fields; single-quote injection in any string field |
| C-01 | 03 | `CSDataTrans.js:17–22` | Auth / Info Disclosure | `GetTwintDataTransData` — unauthenticated GET returns full PII + live HMAC-signed payment payload for any order number |
| C-02 | 03 | `CSDataTrans.js:116–136` | Auth / Order Integrity | `ErrorTransaction` — unauthenticated POST calls `OrderMgr.failOrder()` with any `refno` |
| C-03 | 03 | `CSDataTrans.js:143–163` | Auth / Order Integrity | `CancelTransaction` — unauthenticated POST calls `OrderMgr.failOrder()` with any `refno` |
| P-01 | 04 | `CSBilling.xml:EditBillingAddress` | Auth / CSRF | No auth check, no CSRF pipelet on billing address edit |
| P-02 | 04 | `CSPayments.xml:GetPaymentInfo` | Auth / CSRF | No CS agent auth, no CSRF on payment info retrieval |
| P-03 | 04 | `CSPayments.xml:AddPayment` | Auth / CSRF | No CS agent auth, no CSRF on payment add |
| P-04 | 04 | `CSPayments.xml:EditPayment` | Auth / CSRF | No CS agent auth, no CSRF on payment edit |
| P-05 | 04 | `CSSubmit.xml:SaveOrder` | CSRF | Authenticated but no CSRF on order submission `interaction-continue-node` |
| P-06 | 04 | `CSProduct.xml:UpdateProductSetProduct` | Auth / HTTPS | No auth, `secure="false"` — product set updates without credentials over HTTP |
| T-01 | 05 | `cssuite/app/home.isml:54` | XSS (Reflected) | `${pdict.errorDetail}` from unauthenticated POST rendered on unauthenticated page |
| T-02 | 05 | `cssuite/app/home.isml:52,54,56` | XSS (Reflected) | `${pdict.orderNo}` from POST body rendered in three `<p>` tags |
| T-03 | 05 | `common/errorMessageDialog.isml:18,24` | XSS | `pdict.ErrorJSAction` with `encoding="off"` inside `<script>` block |
| T-04 | 05 | `common/successMessageDialog.isml:12,18` | XSS | `pdict.SuccessJSAction` with `encoding="off"` inside `<script>` block |
| T-05 | 05 | `cssuite/cart/notes.isml:9` | XSS | `${pdict.SuccessJSAction}` raw interpolation inside `<script>` block |
| J-01 | 07 | `js/cssuite.js:77` | eval / XSS | `window['eval']('(' + jQuery(this).html() + ')')` on every `.hidden.json` element at page load |
| J-02 | 07 | `js/customer.js:53–78` | XSS (DOM) | `$('#customer_tooltip').html(...)` with 9 unescaped customer fields including email, login, phone |
| J-03 | 07 | `js/product.js:48–62` | XSS (DOM) | `$('#product_tooltip').html(...)` with `unescape(name)` re-decoding percent-encoded payloads |

---

## High (33)

| ID | Phase | File:line | Category | Summary |
|---|---|---|---|---|
| D-01 | 02 | `head.isml:9` | Dependency | jQuery 1.7.2 — CVE-2015-9251, CVE-2019-11358, CVE-2020-11022, CVE-2020-11023 |
| D-02 | 02 | `jquery.validate.min.js:1` | Dependency | jQuery Validate 1.5.1 — CVE-2021-21252 ReDoS |
| D-03 | 02 | `run/badge.swf` | Dependency | Adobe Flash EOL 2020; SWF asset still served |
| C-04 | 03 | `CSDataTrans.js:334–343` | Auth | `PayByLinkOnBehalf` — no auth, no CSRF, resets premium delivery payment state |
| C-05 | 03 | `CSDataTrans.js:107–109` | Auth / CSRF | `SuccessfulTransaction` — no auth, no CSRF, order number reflected into view |
| C-06 | 03 | `CSDataTrans.js:117–136` | XSS (Reflected) | `errorDetail` from POST body unsanitised into view context; template confirms materialisation |
| C-07 | 03 | `CSDataTrans.js:283–299` | Auth Bypass | `datatransDisableOriginFiltering` preference bypasses IP whitelist unconditionally |
| P-07 | 04 | `CSOrderOnBehalf.xml:Registered` | IDOR | `LoginOnBehalfCustomer` with `custid.value` from request — any agent, any customer |
| P-08 | 04 | `CSOrderOnBehalf.xml:Start` | IDOR | Duplicate login-on-behalf path via public start-node |
| P-09 | 04 | `CSOrder.xml:Cancel` | CSRF | Authenticated but no CSRF on order cancel confirmation |
| P-10 | 04 | `CSShipping.xml:CreateShipment` | Auth / CSRF | No explicit CS agent auth, no CSRF on shipping address save |
| P-11 | 04 | `CSStore.xml:CreateOrderStatusCO` | HTTPS / CSRF | `secure="false"`, no CSRF, raw `codentify` parameter map passed to downstream script |
| P-12 | 04 | `CSCustomer.xml:ResetPassword` | IDOR | Any CS agent can reset any customer's password by `login` parameter |
| P-13 | 04 | `CSSuite.xml:Run` | Auth | `Run` start-node public, `secure="true"`, no auth check — renders home to unauthenticated callers |
| P-14 | 04 | `CSProduct.xml:DialogShowProduct` | Auth | Public with no auth, exposes internal product data for any `pid` |
| T-06 | 05 | `customerhits.isml:154` | XSS (Stored) | 5 customer fields (email, phone, custNo, IDNumber, IDType) unescaped in `onclick=` JS string |
| T-07 | 05 | `customerhitsocapi.isml:74` | XSS (Stored) | Same as T-06 in OCAPI customer hits template |
| T-08 | 05 | `general_info.isml:59` | XSS (Stored) | `${basket.customerName}` inside `<script>` block JS string literal |
| T-09 | 05 | `cssuite/cart/notes.isml:30` | XSS (Stored) | Order note text in `onclick=` attribute — CS agent to CS agent stored XSS |
| SC-04 | 06 | `scripts/common/IsAuthorised.ds:56` | Auth Logic Bug | `authorisedRoles == ['*']` is always false — wildcard ACL check broken |
| SC-05 | 06 | `scripts/common/inputField.js:106` | XSS (HTML Injection) | Custom attribute key/value concatenated without encoding; rendered with `encoding="off"` |
| SC-06 | 06 | `scripts/common/inputField.js:262` | XSS (HTML Injection) | `pdict.onclick` embedded verbatim in `onclick=` attribute |
| SC-07 | 06 | `scripts/common/inputField.js:44` | HTML Attribute Injection | `data-reference-id` attribute built without encoding; `"` terminates attribute |
| F-01 | 07 | `csslogin.xml:3–4` | Auth / DoS | No `max-length` on login/password fields — hash-DoS via multi-MB password submission |
| F-02 | 07 | `csscreditcard.xml:22` | Input Validation | CVV field has no `max-length` or `regexp` |
| J-04 | 07 | `js/dialog.js:434` | XSS (DOM) | `dialogDiv.innerHTML = "<iframe src='" + url + "'"` — URL from potentially broken onclick context |
| J-05 | 07 | `js/order.js:1574` | XSS (DOM) | `container.innerHTML = externalOrderStatus` — raw AJAX response injected into DOM |
| J-06 | 07 | `js/dialog.js:573,620` | XSS (DOM) | `dialogDiv.innerHTML = message` in `Dialog.message/errorMessage()`; linked to T-03 chain |
| J-07 | 07 | `js/order.js:229` | XSS (DOM) | `getElementById('shipping_description').innerHTML = el.title` — title from server template |
| CC-01 | 08 | `CSDataTrans.js:357` | Auth / Crypto | `decryptCustomerNo(refno)` on unauthenticated webhook; fallback splits raw refno on `_` |
| CC-04 | 08 | `CSDataTrans.js:448–465` | Auth | Email sending and PII extraction triggered on unauthenticated webhook after non-constant-time HMAC |
| CC-09 | 08 | `GetRoles.ds:27` / `OCAPIFacade` | Credential Flow | Plaintext agent password forwarded through pipeline dict to `OCAPIFacade.getUserRoles()` |
| CC-12 | 08 | `EncryptionUtil.js:12–18` | Cryptography | Static IV for AES-CBC; identical ciphertexts for same customerNo; lookup-table attack surface |

---

## Medium (53)

| ID | Phase | File:line | Category | Summary |
|---|---|---|---|---|
| D-04 | 02 | `ui.accordion-*.min.js`, `head.isml:13` | Dependency | jQuery UI 1.7.2 / 1.8.20 — CVE-2021-41182/83/84 (XSS) |
| D-05 | 02 | `head.isml:10` | Dependency | jQuery UI 1.12.0 (CDN) — same 3 XSS CVEs |
| D-06 | 02 | `jquery.ba-bbq.min.js:2` | Dependency | jQuery BBQ 1.2.1 — abandoned 2010, `location.hash` parsing risks |
| J-02(cfg) | 02 | `scripts/test/SendMail.js:19` | Test Artefact | Test mail script reachable as workflow step; sends real emails if triggered |
| C-08 | 03 | `CSDataTrans.js:195` | Crypto | Non-constant-time HMAC comparison (`!==`) on `UpdateOrderStatus` webhook |
| C-09 | 03 | `CSDataTrans.js:370` | Crypto | Same non-constant-time HMAC on `UpdatePremiumDeliveryOnBehalf` |
| C-10 | 03 | `CSDataTrans.js:357` | Auth / Logic | Customer number fallback from `refno.split('_')[0]` allows targeting arbitrary customers |
| C-11 | 03 | `CSCustomerOCAPI.js:19` | Input Validation | Full `HttpParameterMap` forwarded to `OCAPIFacade.searchCustomers()` without allow-list |
| C-12 | 03 | `CSOrderOCAPI.js:19` | Input Validation | Full `HttpParameterMap` forwarded to `OCAPIFacade.getCSSuiteOrders()` without allow-list |
| C-13 | 03 | `CSCustomerOCAPI.js:39–73` | IDOR | Any agent can retrieve full address book and PII for any customer via `Get` endpoint |
| P-15 | 04 | `CSLogin.xml:LoginSessionExpired` | CSRF | Login form submission without CSRF pipelet — login CSRF possible |
| P-16 | 04 | `CSOrderOnBehalf.xml:PremiumDelivery` | HTTPS | `secure="false"` on premium delivery on-behalf actions; customerNo and login over HTTP |
| P-17 | 04 | `CSStore.xml:InStoreOrdersReport` | HTTPS | `secure="false"` on agent report; agentID and dates over HTTP |
| P-18 | 04 | `CSOrder.xml:ViewImmutableOrderDetails` | XSS (Reflected) | `orderno.value` concatenated into error string in ScriptNode; template rendering unverified |
| P-19 | 04 | `CSCart.xml:CreateReturnBasket` | HTTPS | `secure="false"` on basket/order data endpoint |
| P-20 | 04 | `CSCart.xml:SelectBonusProduct` | HTTPS | `secure="false"` on basket modification |
| P-21 | 04 | `CSCart.xml` (multiple) | Input Validation | Full `HttpParameterMap` passed to ScriptNodes at 5 locations without allow-list |
| P-22 | 04 | `CSSubmit.xml:1065` | Input Validation | Full `HttpParameterMap` passed to `ValidateTradeIn.ds` (note: param name typo `httpParamterMap`) |
| P-23 | 04 | `CSPayments.xml:SelectPaymentMethod` | Logic / Injection | Dynamic pipeline name from script output variable — possible pipeline injection if input-controlled |
| P-24 | 04 | `CSOrder.xml:AddNote` | Input Validation | Note subject/text passed as `.value` (not `.stringValue`) — unbounded note content |
| T-10 | 05 | `shipment.isml:151–152` | XSS (Stored) | `trackingLink` with `encoding="off"` in `href` — `javascript:` URL if attacker-influenced |
| T-11 | 05 | `utils/redirect.isml:5,22,26` | Open Redirect | `${pdict.Location}` used in `<isredirect>`, meta-refresh, and `<a href>` without validation |
| T-12 | 05 | `cssuite/search/orderhits.isml:144,151` | XSS / Open Redirect | `${order.custom.PayByLinkURL}` in `href=` — `javascript:` URL if stored value is malicious |
| T-13 | 05 | `orderhitsocapi.isml:168,176` | XSS / Open Redirect | Same as T-12 for OCAPI order hits template |
| T-14 | 05 | `paymentdetailsDATATRANS_TWINT_CSSUITE.isml:3` | XSS / Attribute Injection | 7 DataTrans params concatenated in `href=` without `encoding="htmlcontent"` |
| T-15 | 05 | `ocapitoomanyhits.isml:5` | XSS (Reflected) | `${pdict.errorMsg}` from OCAPI error response — HTML-encoded but requires data-flow verification |
| T-16 | 05 | `common/gtm.isml:12` | XSS (Script Breakout) | `JSON.stringify(pageContext)` with `encoding="off"` — `</script>` not escaped by JSON.stringify |
| T-17 | 05 | `utils/inputfield.isml:16–41` | XSS | Multiple `inputField.*` with `encoding="off"` — rendering HTML fragments from JS-built strings |
| SC-08 | 06 | `scripts/css/utils.ds:46` | Unsafe eval | `eval("obj." + prop)` with caller-supplied prop — latent injection if user-controlled callers exist |
| SC-09 | 06 | `scripts/customer/SearchCustomer.ds:60` | PII in Logs | Full OQL query with customer email, name, customerNo logged at INFO level |
| SC-10 | 06 | `scripts/order/SearchOrders.ds:88` | PII in Logs | Full order OQL query with customer PII logged at INFO level |
| SC-11 | 06 | `scripts/common/GetRoles.ds:33` | PII in Logs | Agent login name logged on auth failure — creates enumeration record |
| SC-12 | 06 | `scripts/cart/ValidateTradeIn.ds:13–45` | Session Pollution | Raw request params written to `session.custom.*` without validation — persist across session |
| SC-13 | 06 | `scripts/customer/SearchCustomer.ds:46–51` | Query Injection | Site preference value concatenated into OQL query — admin-editable injection point |
| SC-14 | 06 | `scripts/order/AddNoteToSessionNotes.ds:39` | Session Pollution | Unbounded note text stored in `session.privacy` from `.value` (not `.stringValue`) |
| SC-15 | 06 | `scripts/test/SendMail.js:19` | Test Artefact | Confirmed reachable as workflow step (see J-02 in 02-config.md) |
| F-03 | 07 | `cssbillingaddress.xml:9` | Validation | Billing postal `mandatory="false"` — AVS bypass; no `regexp` on either billing/shipping postal |
| F-04 | 07 | `cssbillingaddress.xml:16`, `cssshippingaddress.xml:24` | Input Validation | Phone field — max-length only, no regexp; `cssorderaddress.xml` has correct regexp |
| F-05 | 07 | `cssbillingaddress.xml:9`, `cssshippingaddress.xml:9` | Input Validation | Postal accepts any 4–10 char string; no format regexp |
| J-08 | 07 | `js/dialog.js:452` | eval | `setInterval(string, ...)` — string argument evaluated like eval; URLUtils value but risky pattern |
| J-09 | 07 | All AJAX calls | CSRF | No AJAX call sends a CSRF token — end-to-end confirmation of no CSRF protection in request layer |
| J-10 | 07 | `js/cssuite.js:381` | XSS (DOM via AJAX) | `jQuery(options.selector).html(response)` — generic AJAX response injected into DOM |
| J-11 | 07 | `js/customer.js:49` | XSS (DOM) | `login` embedded in double-quoted JS string inside `onclick=` — quote-breakout path |
| CC-02 | 08 | `scripts/order/SendMail.js:35` | Info Disclosure | `toHashMap({Order: order, ...})` may deep-serialize payment instruments and PayByLink URLs to email template |
| CC-03 | 08 | `scripts/cart/ValidateTradeIn.ds:30–45` | Session Pollution | `TradeInHelper.isTradeInCartValid()` called after session write from request params |
| CC-05 | 08 | `scripts/test/SendMail.js:19` | Test Artefact | `TemplateHelper` from `app_core_jobs` used in production-reachable test script |
| CC-06 | 08 | `scripts/payments/ProcessAdyenCancellationAndRefund.ds:22` | CSRF → Financial | Cancel/refund callable via CSRF-vulnerable `CSOrder-Cancel` pipeline |
| CC-07 | 08 | `scripts/payments/GetDatatransPayByLink.ds:35` | Dependency | `DataTransFacade.getPayByLink` — platform-object inputs only; service SSL/credential hygiene unverified |
| CC-08 | 08 | `CSOrderOCAPI.js:19`, `CSCustomerOCAPI.js:19` | Input Validation | Raw `HttpParameterMap` to `OCAPIFacade` — facade extracts named params but `OrderSearch`/`CustomerSearch` query builders unaudited |
| CC-10 | 08 | Multiple `HookMgr.callHook()` sites | Unaudited | 8 hooks pass basket/order data to unknown implementors |
| CC-11 | 08 | `OCAPIFacade.js:306` | Info Disclosure | `getOrdersForDISP` defaults to `select = '(**)'` — returns all PII fields when stripOffPersonalData is false |
| CC-13 | 08 | `DataTransFacade.js:173` | Token Lifecycle | `deleteToken` throws ReferenceError at runtime — card aliases never deleted; PCI/GDPR compliance failure |
| CC-14 | 08 | `EmailNotifications.js:131,769,799` | Phishing | `premDeliveryPaymentLink` attribute embedded unvalidated in 3 email templates — stored phishing vector |

---

## Low (25)

| ID | Phase | File:line | Category | Summary |
|---|---|---|---|---|
| D-07 | 02 | `jquery.cookie.js` (×2) | Dependency | Two copies of deprecated jQuery Cookie plugin; no CVEs but unmaintained |
| D-08 | 02 | `login.isml:7` | Dependency | jQuery 3.6.0 loaded on login page alongside 1.7.2 — dual jQuery instances |
| C-14 | 03 | `CSDataTrans.js:46` | Error Handling | `customerProfile.getBirthday()` null dereference — unhandled TypeError for customers without birthday |
| C-15 | 03 | `CSDataTrans.js:162` | Info Disclosure | "order was not found" on unauthenticated page confirms order existence (enumeration oracle) |
| C-16 | 03 | `CSCustomerOCAPI.js:9–11` | Auth | Auth state indeterminate if `CSLogin-RequireAuthorization` pipeline returns unexpected result |
| P-25 | 04 | `CSSuite.xml:SFHeaderInclude` | Auth | Public, `secure="false"`, no auth — renders storefront header to unauthenticated callers |
| P-26 | 04 | `CSKeepSessionAlive.xml:Start` | Auth | Public session keepalive responds to unauthenticated callers — server probe surface |
| P-27 | 04 | `CSCart.xml` (multiple) | HTTPS | `secure="false"` on basket mutation operations |
| T-18 | 05 | `addproducttoshipments.isml:40` | XSS | `${product.shortDescription}` with `encoding="off"` — merchant-controlled data |
| T-19 | 05 | `addpayment.isml:30` | XSS | `${paymentMethod.getName()}` with `encoding="off"` — BM-configured data |
| T-20 | 05 | `content/content.isml:11` | XSS | CMS body with `encoding="off"` — intentional HTML but merchant-editable |
| T-21 | 05 | `email/orderchange.isml:6` | Email Header Injection | `encoding="off"` in `<subject>` with order number — newline injection possible |
| T-22 | 05 | `product/components/variations.isml:67,69` | CSS Injection | `${swatchStyle}` with `encoding="off"` in `style=` attribute |
| T-23 | 05 | `customerhits.isml:154` | Incomplete Sanitization | Manual JS escaping (4 regex replaces) misses `<`, `>`, `;`, Unicode — incomplete protection |
| T-24 | 05 | `common/gtm.isml:29` | SSRF (low confidence) | `<isinclude url="${result}">` with order/product ID path params — URLUtils restricts to same-origin |
| SC-16 | 06 | `scripts/cart/PreOrderAttributesUpdate.ds:21` | PII in Logs | `customerNo` in error-level log |
| SC-17 | 06 | `scripts/common/GetRoles.ds:25,27` | Credential Flow | Plaintext password in pipeline dictionary visible at debug log level |
| SC-18 | 06 | `scripts/order/SearchOrders.ds:92` | Info Disclosure | OQL query with customer data exported in `pdict.query` |
| F-06 | 07 | `csslogin.xml:1` | HTTPS | Login form `secure="false"` at form definition level — defense-in-depth gap |
| F-07 | 07 | `cssbillingaddress.xml` | Input Validation | 3 fields without `max-length`: `area`, `addresslookup`, `taxID` |
| F-08 | 07 | `cssshippingaddress.xml` | Input Validation | 3 fields without `max-length`: `parcelShopID`, `parcelShop`, `addresslookup` |
| F-09 | 07 | `csshipping.xml:4` | Input Validation | `trackingNumber` — no `max-length`, no `regexp` |
| F-10 | 07 | `csspayment.xml:17` | Missing Form | `<include formid="bml">` references missing `bml` form definition |
| J-12 | 07 | `js/dialog.js:430–431` | XSS (DOM) | `unescape(customerName)` in dialog title — re-decodes percent-encoded characters |
| J-13 | 07 | `js/order.js:434` | XSS (DOM) | `$('#order_number').html(Order.orderNo)` — should use `.text()` |
| CC-15 | 08 | `EmailNotifications.js:43–61` | App Integrity | Locale not restored in `finally` block — request locale corrupted on exception |

---

## Info (9)

| ID | Phase | File:line | Category | Summary |
|---|---|---|---|---|
| S-01 | 02 | `order.properties:9,14` | Config | Hardcoded phone number in email template — SiteGenesis demo data, requires deploy to change |
| S-02 | 02 | `order.properties:12-13` | Config | Hardcoded store address in email template — same concern |
| S-03 | 02 | N/A | Config | No `services.xml`/`credentials.xml` in this cartridge — live in integration cartridges |
| H-01 | 02 | N/A | Config | No `hooks.json` in this cartridge — no hook registrations |
| J-01(cfg) | 02 | N/A | Config | No `steps.json` — no job step registrations |
| SC-19 | 06 | `scripts/common/dynamicForm.js:22–27` | Logic Error | `min` and `max` validator fields are swapped — incorrect client-side validation bounds |
| J-14 | 07 | (none) | Info | No hardcoded API keys or auth tokens in any application JS file |
| J-15 | 07 | (none) | Info | No `localStorage`/`sessionStorage` writes of credentials in any application JS file |
