import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonSlurper

// BƯỚC 1: PHẢI GỌI API TRƯỚC (Dòng này cực kỳ quan trọng)
// Bạn nhớ kiểm tra xem 'Get_Random_User' có nằm đúng trong Object Repository không nhé
def response = WS.sendRequest(findTestObject('Object Repository/Get_Random_User'))

// BƯỚC 2: PHÂN TÍCH DỮ LIỆU
def slurper = new JsonSlurper()
def result = slurper.parseText(response.getResponseBodyContent())

// BƯỚC 3: TRÍCH XUẤT THÔNG TIN
String apiEmail = result.results[0].email
String apiUsername = result.results[0].login.username

println ">>> Username lay tu API: " + apiUsername
println ">>> Email lay tu API: " + apiEmail

// BƯỚC 4: ĐIỀN VÀO WEB
WebUI.openBrowser('https://parabank.parasoft.com/parabank/register.htm')
WebUI.maximizeWindow()

// Điền Username (Bạn đang dùng cùng 1 Object cho cả 2 dòng nên tôi đã tách ra nhé)
WebUI.setText(findTestObject('Object Repository/Page_ParaBank  Register for Free Online Account Access/input_Username_customer.username'), apiUsername)

// Chỗ này bạn hãy kéo Object của ô Email/First Name thả vào nhé:
WebUI.setText(findTestObject('Object Repository/Page_ParaBank  Register for Free Online Account Access/input_Customer.FirstName'), apiEmail)