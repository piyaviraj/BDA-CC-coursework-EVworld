package com.evworld.price.repositories.utils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.common.hash.Hashing;

public class MetaDataUtils {

	public static List<String> getHashList(int tokenCount) {
		String timeToken = Long.toHexString(System.currentTimeMillis());
		List<String> tokens = new ArrayList<>();
		for(int i = 0; i < tokenCount; ++i) {
			timeToken = Hashing.sha256()
					  .hashString(timeToken, StandardCharsets.UTF_8)
					  .toString();
			tokens.add(timeToken);
		}
		return tokens;
	}

}
