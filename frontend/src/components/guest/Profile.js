import React, { useState } from "react";
import "../../css/profile.css";
import { Link } from "react-router-dom";
import { RiUserLine, RiFileList3Line } from "react-icons/ri";

const Profile = ({ auth, isUpdate, changepass }) => {
    const [profile, setProfile] = useState({
        username: auth.username,
        email: auth.email,
        fullName: auth.fullName,
        currentPassword: "",
        newPassword: "",
        confirmPassword: "",
    });

    const onChange = (event) => {
        const { name, value } = event.target;
        setProfile({
            ...profile,
            [name]: value,
        });
    };

    return (
        <div className="profile">
            <div className="container">
                <div className="row m-0 profile-layout">
                    <div className="col-3 py-3 profile-menu">
                        <div className="row m-0 d-flex pb-3 account">
                            <div className="col-4 p-0 d-flex justify-content-center align-items-center">
                                <img
                                    src="https://www.donki.com/en/official-character/asset/img/profile/donpenProf03.png"
                                    className="img-fluid"
                                    width="100%"
                                    alt="avatar"
                                />
                            </div>
                            <div className="col-8 p-0">
                                <div className="d-grid">
                                    <span>
                                        <b>{auth.username}</b>
                                    </span>
                                    <span>{auth.fullName}</span>
                                </div>
                            </div>
                        </div>
                        <div className="row m-0 sub-menu mt-4">
                            <Link to="myprofile">
                                <div className="h-100 btn d-flex justify-content-center align-items-center">
                                    <div className="col-3 icon-submenu">
                                        <RiUserLine />
                                    </div>
                                    <div className="col-9 text-start">
                                        <span>Tài khoản của tôi</span>
                                    </div>
                                </div>
                            </Link>
                            <Link to="updateprofile">
                                <div className="h-100 btn d-flex justify-content-center align-items-center">
                                    <div className="col-3 icon-submenu"></div>
                                    <div className="col-9 text-start">
                                        <span>Cập nhật thông tin</span>
                                    </div>
                                </div>
                            </Link>
                            <Link to="changepassword">
                                <div className="h-100 btn d-flex justify-content-center align-items-center">
                                    <div className="col-3 icon-submenu"></div>
                                    <div className="col-9 text-start">
                                        <span>Đổi mật khẩu</span>
                                    </div>
                                </div>
                            </Link>
                            <Link to="#">
                                <div className="h-100 btn d-flex justify-content-center align-items-center">
                                    <div className="col-3 icon-submenu">
                                        <RiFileList3Line />
                                    </div>
                                    <div className="col-9 text-start">
                                        <span>Đơn mua</span>
                                    </div>
                                </div>
                            </Link>
                        </div>
                    </div>
                    <div className="col-9">
                        <div className="card py-3">
                            <div className="px-4">
                                {changepass ? (
                                    <div className="title pb-3">
                                        <h4>Đổi mật khẩu</h4>
                                        <small>
                                            Để bảo mật tài khoản, vui lòng không chia sẻ mật khẩu
                                            cho người khác
                                        </small>
                                    </div>
                                ) : (
                                    <div className="title pb-3">
                                        <h4>Hồ sơ của tôi</h4>
                                        {isUpdate ? (
                                            <small>
                                                Quản lý thông tin hồ sơ để bảo mật tài khoản
                                            </small>
                                        ) : (
                                            <small>Thông tin hồ sơ</small>
                                        )}
                                    </div>
                                )}
                                <div className="content-info mt-4">
                                    <div className="row m-0">
                                        <div
                                            className={
                                                changepass
                                                    ? "col-12 left-content"
                                                    : "col-8 left-content"
                                            }
                                        >
                                            <div className="row d-flex align-items-center username pt-4">
                                                <div className="col-4 label">
                                                    {changepass ? (
                                                        <label htmlFor="currentpass">
                                                            Mật khẩu hiện tại
                                                        </label>
                                                    ) : (
                                                        <label htmlFor="username">
                                                            Tên đăng nhập
                                                        </label>
                                                    )}
                                                </div>
                                                <div className="col-8 content">
                                                    {changepass ? (
                                                        <input
                                                            type="password"
                                                            id="currentpass"
                                                            value={profile.currentPassword}
                                                            name="currentPassword"
                                                            onChange={onChange}
                                                        />
                                                    ) : (
                                                        <span>{profile.username}</span>
                                                    )}
                                                </div>
                                            </div>
                                            <div className="row d-flex align-items-center fullname pt-4">
                                                <div className="col-4 label">
                                                    {changepass ? (
                                                        <label htmlFor="newpass">
                                                            Mật khẩu mới
                                                        </label>
                                                    ) : (
                                                        <label htmlFor="fullname">Họ và tên</label>
                                                    )}
                                                </div>
                                                <div className="col-8 content">
                                                    {changepass ? (
                                                        <input
                                                            type="password"
                                                            id="newpass"
                                                            value={profile.newPassword}
                                                            name="newPassword"
                                                            onChange={onChange}
                                                        />
                                                    ) : isUpdate ? (
                                                        <input
                                                            type="text"
                                                            id="fullname"
                                                            value={profile.fullName}
                                                            name="fullName"
                                                            onChange={onChange}
                                                        />
                                                    ) : (
                                                        <span>{profile.fullName}</span>
                                                    )}
                                                </div>
                                            </div>
                                            <div className="row d-flex align-items-center email pt-4">
                                                <div className="col-4 label">
                                                    {changepass ? (
                                                        <label htmlFor="confirmpass">
                                                            Xác nhận mật khẩu mới
                                                        </label>
                                                    ) : (
                                                        <label htmlFor="email">Email</label>
                                                    )}
                                                </div>
                                                <div className="col-8 content">
                                                    {changepass ? (
                                                        <input
                                                            type="password"
                                                            id="confirmpass"
                                                            value={profile.confirmPassword}
                                                            name="confirmPassword"
                                                            onChange={onChange}
                                                        />
                                                    ) : isUpdate ? (
                                                        <input
                                                            type="email"
                                                            id="email"
                                                            value={profile.email}
                                                            name="email"
                                                            onChange={onChange}
                                                        />
                                                    ) : (
                                                        <span>{profile.email}</span>
                                                    )}
                                                </div>
                                            </div>
                                            <div className="row d-flex align-items-center pt-4">
                                                <div className="col-4 label"></div>
                                                <div className="col-8">
                                                    {changepass ? (
                                                        <>
                                                            <Link
                                                                to="changepassword"
                                                                className="save-btn col-6"
                                                            >
                                                                <div className="btn">Xác nhận</div>
                                                            </Link>
                                                            <Link to="#" style={{ float: "right" }}>
                                                                <div className="btn border-0 forget-btn">
                                                                    Quên mật khẩu?
                                                                </div>
                                                            </Link>
                                                        </>
                                                    ) : isUpdate ? (
                                                        <Link to="myprofile" className="save-btn">
                                                            <div className="btn">Lưu</div>
                                                        </Link>
                                                    ) : (
                                                        <Link
                                                            to="updateprofile"
                                                            className="save-btn"
                                                        >
                                                            <div className="btn">Chỉnh sửa</div>
                                                        </Link>
                                                    )}
                                                </div>
                                            </div>
                                        </div>
                                        {changepass ? (
                                            <></>
                                        ) : (
                                            <div className="col-4 right-content d-grid justify-content-center align-items-center">
                                                <div className="text-center d-flex align-items-center justify-content-center avatar">
                                                    {isUpdate ? (
                                                        <label
                                                            htmlFor="file"
                                                            className="btn border-0 p-0"
                                                        >
                                                            <img
                                                                src="https://www.donki.com/en/official-character/asset/img/profile/donpenProf03.png"
                                                                className="img-fluid"
                                                                alt="avatar"
                                                            />
                                                        </label>
                                                    ) : (
                                                        <img
                                                            src="https://www.donki.com/en/official-character/asset/img/profile/donpenProf03.png"
                                                            className="img-fluid"
                                                            alt="avatar"
                                                        />
                                                    )}
                                                </div>
                                                <div className="text-center">
                                                    {isUpdate ? (
                                                        <>
                                                            <input
                                                                type="file"
                                                                id="file"
                                                                accept="image/*"
                                                                name="photo"
                                                                onChange={onChange}
                                                            />
                                                            <label htmlFor="file" className="btn">
                                                                Chọn ảnh
                                                            </label>
                                                        </>
                                                    ) : (
                                                        <span>Hình ảnh đại diện</span>
                                                    )}
                                                </div>
                                            </div>
                                        )}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Profile;
