<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 5/26/2025
  Time: 7:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Tờ khai y tế</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 p-6">
<div class="max-w-4xl mx-auto bg-white p-6 rounded-lg shadow-md">
    <h1 class="text-3xl font-bold text-center mb-2">TỜ KHAI Y TẾ</h1>
    <p class="text-center text-red-600 mb-6 font-medium">
        Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự
    </p>

    <c:if test="${not empty error}">
        <div class="text-red-600 mb-4 font-semibold text-sm">${error}</div>
    </c:if>

    <c:if test="${not empty success}">
        <div class="text-green-600 mb-4 font-semibold text-sm">${success}</div>
    </c:if>

    <form:form action="${editIndex != null ? '/update/' + editIndex : '/submit'}" modelAttribute="declaration"
               method="post" cssClass="space-y-6">

        <div>
            <label class="block font-medium mb-1">Họ tên (ghi chữ IN HOA) <span class="text-red-500">*</span></label>
            <form:input path="fullName" cssClass="w-full border border-gray-300 p-2 rounded-md"/>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-3 gap-4">
            <div>
                <label class="block font-medium mb-1">Năm sinh <span class="text-red-500">*</span></label>
                <form:input path="birthYear" cssClass="w-full border border-gray-300 p-2 rounded-md"/>
            </div>
            <div>
                <label class="block font-medium mb-1">Giới tính <span class="text-red-500">*</span></label>
                <form:select path="gender" cssClass="w-full border border-gray-300 p-2 rounded-md">
                    <form:option value="">--Chọn--</form:option>
                    <form:option value="Nam">Nam</form:option>
                    <form:option value="Nữ">Nữ</form:option>
                </form:select>
            </div>
            <div>
                <label class="block font-medium mb-1">Quốc tịch <span class="text-red-500">*</span></label>
                <form:select path="nationality" cssClass="w-full border border-gray-300 p-2 rounded-md">
                    <form:option value="Việt Nam">Việt Nam</form:option>
                    <form:option value="Khác">Khác</form:option>
                </form:select>
            </div>
        </div>

        <div>
            <label class="block font-medium mb-1">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span
                    class="text-red-500">*</span></label>
            <form:input path="idNumber" cssClass="w-full border border-gray-300 p-2 rounded-md"/>
        </div>

        <div>
            <label class="block font-medium mb-1">Thông tin đi lại <span class="text-red-500">*</span></label>
            <div class="flex space-x-4">
                <label><form:radiobutton path="travelInfo" value="Đi lại"/> Đi lại</label>
                <label><form:radiobutton path="travelInfo" value="Tổ thuỷ"/> Tổ thuỷ</label>
                <label><form:radiobutton path="travelInfo" value="Khác"/> Khác</label>
            </div>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-3 gap-4">
            <div>
                <label class="block font-medium mb-1">Tỉnh/thành <span class="text-red-500">*</span></label>
                <form:select path="province" cssClass="w-full border border-gray-300 p-2 rounded-md">
                    <form:option value="">--Chọn--</form:option>
                    <form:option value="Hà Nội">Hà Nội</form:option>
                </form:select>
            </div>
            <div>
                <label class="block font-medium mb-1">Quận/huyện <span class="text-red-500">*</span></label>
                <form:select path="district" cssClass="w-full border border-gray-300 p-2 rounded-md">
                    <form:option value="">--Chọn--</form:option>
                    <form:option value="Ba Đình">Ba Đình</form:option>
                </form:select>
            </div>
            <div>
                <label class="block font-medium mb-1">Phường/xã <span class="text-red-500">*</span></label>
                <form:select path="ward" cssClass="w-full border border-gray-300 p-2 rounded-md">
                    <form:option value="">--Chọn--</form:option>
                    <form:option value="Phúc Xá">Phúc Xá</form:option>
                </form:select>
            </div>
        </div>

        <div>
            <label class="block font-medium mb-1">Địa chỉ nơi ở <span class="text-red-500">*</span></label>
            <form:input path="address" cssClass="w-full border border-gray-300 p-2 rounded-md"/>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <div>
                <label class="block font-medium mb-1">Điện thoại <span class="text-red-500">*</span></label>
                <form:input path="phone" cssClass="w-full border border-gray-300 p-2 rounded-md"/>
            </div>
            <div>
                <label class="block font-medium mb-1">Email</label>
                <form:input path="email" cssClass="w-full border border-gray-300 p-2 rounded-md"/>
            </div>
        </div>

        <div>
            <label class="block font-medium mb-1">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? <span
                    class="text-red-500">*</span></label>
            <form:input path="past14Days" cssClass="w-full border border-gray-300 p-2 rounded-md"/>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <div>
                <label class="block font-medium mb-1">Ngày khởi hành <span class="text-red-500">*</span></label>
                <div class="flex space-x-2">
                    <form:select path="startDate" cssClass="border p-2 rounded-md">
                        <form:option value="">--</form:option>
                        <c:forEach begin="1" end="31" var="d"><form:option value="${d}">${d}</form:option></c:forEach>
                    </form:select>
                    <form:select path="startMonth" cssClass="border p-2 rounded-md">
                        <form:option value="">--</form:option>
                        <c:forEach begin="1" end="12" var="m"><form:option value="${m}">${m}</form:option></c:forEach>
                    </form:select>
                    <form:select path="startYear" cssClass="border p-2 rounded-md">
                        <form:option value="">--</form:option>
                        <c:forEach begin="2020" end="2025" var="y"><form:option
                                value="${y}">${y}</form:option></c:forEach>
                    </form:select>
                </div>
            </div>

            <div>
                <label class="block font-medium mb-1">Ngày kết thúc <span class="text-red-500">*</span></label>
                <div class="flex space-x-2">
                    <form:select path="endDate" cssClass="border p-2 rounded-md">
                        <form:option value="">--</form:option>
                        <c:forEach begin="1" end="31" var="d"><form:option value="${d}">${d}</form:option></c:forEach>
                    </form:select>
                    <form:select path="endMonth" cssClass="border p-2 rounded-md">
                        <form:option value="">--</form:option>
                        <c:forEach begin="1" end="12" var="m"><form:option value="${m}">${m}</form:option></c:forEach>
                    </form:select>
                    <form:select path="endYear" cssClass="border p-2 rounded-md">
                        <form:option value="">--</form:option>
                        <c:forEach begin="2020" end="2025" var="y"><form:option
                                value="${y}">${y}</form:option></c:forEach>
                    </form:select>
                </div>
            </div>
        </div>

        <div>
            <label class="block font-medium mb-1">Triệu chứng</label>
            <div class="flex flex-wrap gap-4">
                <label><form:checkbox path="fever"/> Sốt</label>
                <label><form:checkbox path="cough"/> Ho</label>
                <label><form:checkbox path="breathDifficulty"/> Khó thở</label>
                <label><form:checkbox path="fatigue"/> Mệt mỏi</label>
                <label><form:checkbox path="soreThroat"/> Đau họng</label>
            </div>
        </div>

        <div>
            <label class="block font-medium mb-1">Lịch sử phơi nhiễm</label>
            <div class="flex flex-wrap gap-4">
                <label><form:checkbox path="travelAbroad"/> Xuất nhập cảnh nước ngoài</label>
                <label><form:checkbox path="contact"/> Tiếp xúc gần (&lt;2m) với người mắc bệnh</label>
                <label><form:checkbox path="contactAbroad"/> Tiếp xúc người nước ngoài</label>
                <label><form:checkbox path="contactSymptom"/> Tiếp xúc người có triệu chứng</label>
            </div>
        </div>

        <div class="text-center mt-4">
            <button type="submit" class="bg-green-500 hover:bg-green-600 text-white font-semibold px-6 py-2 rounded-md">
                GỬI TỜ KHAI
            </button>
        </div>
    </form:form>

    <c:if test="${not empty declarations}">
        <div class="mt-8">
            <h2 class="text-xl font-bold mb-2">Danh sách tờ khai</h2>
            <table class="w-full border-collapse border text-sm">
                <thead>
                <tr class="bg-gray-100">
                    <th class="border p-2">Họ tên</th>
                    <th class="border p-2">Năm sinh</th>
                    <th class="border p-2">Giới tính</th>
                    <th class="border p-2">Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${declarations}" var="declaration" varStatus="loop">
                    <tr>
                        <td class="border p-2">${declaration.fullName}</td>
                        <td class="border p-2">${declaration.birthYear}</td>
                        <td class="border p-2">${declaration.gender}</td>
                        <td class="border p-2 text-center">
                            <a href="/edit/${loop.index}" class="text-blue-600 hover:underline">Chỉnh sửa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
