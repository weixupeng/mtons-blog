/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package mblog.persist.dao;

import mblog.persist.entity.FollowPO;
import mtons.modules.persist.Dao;
import mtons.modules.pojos.Paging;

import java.util.List;

/**
 * @author langhsu
 * 
 */
public interface FollowDao extends Dao<FollowPO> {

	/**
	 * 检查是否已关注
	 * 
	 * @param userId
	 * @param followId
	 * @return
	 */
	FollowPO checkFollow(long userId, long followId);

	/**
	 * 查询我的关注
	 * 
	 * @param paging
	 * @param userId
	 */
	List<FollowPO> following(Paging paging, long userId);

	/**
	 * 查询关注我的 (我的粉丝)
	 * 
	 * @param paging
	 * @param userId
	 */
	List<FollowPO> fans(Paging paging, long userId);

	/**
	 * 检查是否相互关注
	 * 
	 * @param userId
	 * @param targetUserId
	 * @return
	 */
	boolean checkCrossFollow(long userId, long targetUserId);
	
	/**
	 * 取消关注
	 * 
	 * @param userId
	 * @param followId
	 * @return
	 */
	int unfollow(long userId, long followId);
}
