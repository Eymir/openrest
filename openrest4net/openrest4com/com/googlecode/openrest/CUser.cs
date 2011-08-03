﻿using System;
using System.Runtime.InteropServices;

namespace com.googlecode.openrest
{
    [ComVisible(true)]
    public class CUser : IUser
    {
        public CUser(User user)
        {
            this.user = user;
        }

        public string GetId()
        {
            return user.id;
        }

        public string GetIpAddress()
        {
            return user.ipAddress;
        }

        public string GetFwdIpAddresses()
        {
            return user.fwdIpAddresses;
        }

        private readonly User user;
    }
}
